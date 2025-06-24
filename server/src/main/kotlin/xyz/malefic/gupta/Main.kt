package xyz.malefic.gupta

import kotlinx.serialization.Serializable
import org.http4k.core.Body
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Response
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.Status.Companion.OK
import org.http4k.core.with
import org.http4k.format.KotlinxSerialization.auto
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.server.Undertow
import org.http4k.server.asServer

@Serializable
data class BlogSummary(
    val id: String,
    val title: String,
    val date: String,
    val image: String,
    val summary: String,
)

val blogSummariesLens = Body.auto<List<BlogSummary>>().toLens()
val blogPostLens = Body.auto<BlogPost>().toLens()

val app: HttpHandler =
    routes(
        "/ping" bind GET to { Response(OK).body("pong") },
        "/posts" bind GET to {
            val summaries =
                Data.blogPosts.map {
                    BlogSummary(it.id, it.title, it.date, it.image, it.summary)
                }
            Response(OK).with(blogSummariesLens of summaries)
        },
        "/posts/{id}" bind GET to { req ->
            val id = req.path("id")
            val post = id?.let { Data.findById(it) }
            if (post != null) {
                Response(OK).with(blogPostLens of post)
            } else {
                Response(NOT_FOUND).body("Blog post not found")
            }
        },
    )

fun main() {
    println("Blog server running on http://localhost:9000")
    app.asServer(Undertow(9000)).start()
}

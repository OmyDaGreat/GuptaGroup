package xyz.malefic.gupta

import co.touchlab.kermit.Logger
import org.http4k.core.Body
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

val logger = Logger.withTag("BlogServer")

val blogSummariesLens = Body.auto<List<BlogPost>>().toLens()
val blogPostLens = Body.auto<BlogPost>().toLens()

val app =
    routes(
        "/ping" bind GET to {
            logger.d { "Ping endpoint hit" }
            Response(OK).body("pong")
        },
        "/posts" bind GET to {
            val summaries = Data.blogPosts
            logger.d { "Returning ${summaries.size} blog summaries" }
            Response(OK).with(blogSummariesLens of summaries)
        },
        "/posts/{id}" bind GET to { req ->
            val id = req.path("id")
            val post = id?.let { Data.findById(it) }
            if (post != null) {
                logger.d { "Found blog post with id: $id" }
                Response(OK).with(blogPostLens of post)
            } else {
                logger.w { "Blog post not found for id: $id" }
                Response(NOT_FOUND).body("Blog post not found")
            }
        },
    )

fun main() {
    logger.i { "Blog server starting on http://localhost:9000" }
    app.asServer(Undertow(9000)).start()
    logger.i { "Blog server started" }
}

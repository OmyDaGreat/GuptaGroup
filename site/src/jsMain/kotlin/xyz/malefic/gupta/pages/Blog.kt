package xyz.malefic.gupta.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text
import xyz.malefic.gupta.styles.BlogButtonStyle
import xyz.malefic.gupta.styles.BlogCardStyle
import xyz.malefic.gupta.styles.BlogPageStyle
import xyz.malefic.gupta.styles.ContainerStyle
import xyz.malefic.gupta.styles.PropertyAddressStyle
import xyz.malefic.gupta.styles.PropertyDetailStyle
import xyz.malefic.gupta.styles.PropertyPriceStyle
import xyz.malefic.gupta.styles.SectionStyle
import xyz.malefic.gupta.styles.SectionTitleStyle

@Serializable
data class BlogSummary(
    val id: String,
    val title: String,
    val date: String,
    val image: String,
    val summary: String,
)

@Page
@Composable
@Suppress("unused")
fun BlogHomePage() {
    var posts by remember { mutableStateOf<List<BlogSummary>?>(null) }
    var error by remember { mutableStateOf<String?>(null) }
    var showAll by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        try {
            val isLocal = window.location.hostname == "localhost"
            val baseUrl = if (isLocal) "http://localhost:9000" else "https://blog.gupta.malefic.xyz"
            val response = window.fetch("$baseUrl/posts").await()
            if (!response.ok) throw Exception("Failed to fetch blogs")
            val json = response.text().await()
            posts = Json.decodeFromString(json)
        } catch (e: Exception) {
            error = e.message
        }
    }

    Column(BlogPageStyle.toModifier(), horizontalAlignment = Alignment.CenterHorizontally) {
        Header()
        Section(SectionStyle.toAttrs()) {
            Div(ContainerStyle.toAttrs()) {
                H2(SectionTitleStyle.toAttrs()) { Text("Blog") }
                P { Text("This site is the blog homepage. All blogs are fetched from blog.gupta.malefic.xyz.") }
                when {
                    error != null -> P { Text("Error: $error") }
                    posts == null -> P { Text("Loading...") }
                    posts!!.isEmpty() -> P { Text("No blog posts found.") }
                    else -> {
                        val featured = posts!!.take(2)
                        val rest = posts!!.drop(2)
                        Column(Modifier.gap(2.cssRem)) {
                            featured.forEach { post ->
                                BlogCardSummary(post)
                            }
                            if (rest.isNotEmpty()) {
                                Button(BlogButtonStyle.toAttrs { onClick { showAll = !showAll } }) {
                                    Text(if (showAll) "Hide more posts" else "Show more posts")
                                }
                                if (showAll) {
                                    rest.forEach { post ->
                                        BlogCardSummary(post)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Footer()
    }
}

@Composable
fun BlogCardSummary(post: BlogSummary) {
    Div(BlogCardStyle(post.image).toAttrs()) {
        H3(PropertyPriceStyle.toAttrs()) { Text(post.title) }
        P(PropertyAddressStyle.toAttrs()) { Text(post.date) }
        P(PropertyDetailStyle.toAttrs()) { Text(post.summary) }
        Row {
            A(
                href = "/blog/${post.id}",
                attrs = {
                    classes("blog-link")
                },
            ) { Text("Read more") }
        }
    }
}

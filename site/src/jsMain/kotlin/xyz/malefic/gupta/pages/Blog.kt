package xyz.malefic.gupta.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonIgnoreUnknownKeys
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import xyz.malefic.gupta.components.ThemedLink
import xyz.malefic.gupta.styles.BlogButtonStyle
import xyz.malefic.gupta.styles.BlogCardAddressStyle
import xyz.malefic.gupta.styles.BlogCardContentStyle
import xyz.malefic.gupta.styles.BlogCardOverlayStyle
import xyz.malefic.gupta.styles.BlogCardStyle
import xyz.malefic.gupta.styles.BlogCardSummaryStyle
import xyz.malefic.gupta.styles.BlogCardTitleStyle
import xyz.malefic.gupta.styles.BlogPageStyle
import xyz.malefic.gupta.styles.ContainerStyle
import xyz.malefic.gupta.styles.SectionTitleStyle

@Serializable
@JsonIgnoreUnknownKeys
@OptIn(ExperimentalSerializationApi::class)
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
    Column(
        BlogPageStyle.toModifier(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header()
        BlogSection()
        Footer()
    }
}

@Composable
fun BlogSection() {
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

    Div(ContainerStyle.toAttrs()) {
        H2(SectionTitleStyle.toAttrs()) { Text("Blog") }
        BlogList(posts, error, showAll, onToggleShowAll = { showAll = !showAll })
    }
}

@Composable
fun BlogList(
    posts: List<BlogSummary>?,
    error: String?,
    showAll: Boolean,
    onToggleShowAll: () -> Unit,
) {
    when {
        error != null -> P { Text("Error: $error") }
        posts == null -> P { Text("Loading...") }
        posts.isEmpty() -> P { Text("No blog posts found.") }
        else -> {
            val featured = posts.take(2)
            val rest = posts.drop(2)
            Column(
                Modifier.gap(2.cssRem).margin { bottom(2.cssRem) },
            ) {
                val visiblePosts = if (showAll) posts else featured
                visiblePosts.forEach { post ->
                    BlogCardSummary(post)
                }
            }
            if (rest.isNotEmpty()) {
                Button(
                    BlogButtonStyle.toAttrs {
                        onClick { onToggleShowAll() }
                    },
                ) {
                    Text(if (showAll) "Hide more posts" else "Show more posts")
                }
            }
        }
    }
}

@Composable
fun BlogCardSummary(post: BlogSummary) {
    Div(BlogCardStyle(post.image).toAttrs()) {
        Div(BlogCardOverlayStyle.toAttrs())
        Div(BlogCardContentStyle.toAttrs()) {
            H3(BlogCardTitleStyle.toAttrs()) { Text(post.title) }
            P(BlogCardAddressStyle.toAttrs()) { Text(post.date) }
            P(BlogCardSummaryStyle.toAttrs()) { Text(post.summary) }
            ThemedLink("/blog/${post.id}", "Read more", Modifier.gap(0.5.cssRem))
        }
    }
}

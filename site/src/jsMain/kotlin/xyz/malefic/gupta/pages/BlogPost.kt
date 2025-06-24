package xyz.malefic.gupta.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.silk.style.toAttrs
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text
import xyz.malefic.gupta.styles.ContainerStyle
import xyz.malefic.gupta.styles.PropertyAddressStyle
import xyz.malefic.gupta.styles.PropertyDetailStyle
import xyz.malefic.gupta.styles.SectionStyle
import xyz.malefic.gupta.styles.SectionTitleStyle

@Serializable
data class BlogPost(
    val id: String,
    val title: String,
    val date: String,
    val image: String,
    val text: String,
)

@Page("/blog/{id}")
@Composable
@Suppress("unused")
fun BlogPostPage(ctx: PageContext) {
    val id = ctx.route.params["id"] ?: return
    var post by remember { mutableStateOf<BlogPost?>(null) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(id) {
        try {
            val isLocal = window.location.hostname == "localhost"
            val baseUrl = if (isLocal) "http://localhost:9000" else "https://blog.gupta.malefic.xyz"
            val response = window.fetch("$baseUrl/posts/$id").await()
            if (!response.ok) throw Exception("Failed to fetch blog post")
            val json = response.text().await()
            post = Json.decodeFromString(json)
        } catch (e: Exception) {
            error = e.message
        }
    }

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Header()
        Section(SectionStyle.toAttrs()) {
            Div(ContainerStyle.toAttrs()) {
                when {
                    error != null -> P { Text("Error: $error") }
                    post == null -> P { Text("Loading...") }
                    else -> {
                        Img(src = post!!.image, attrs = { style { property("width", "100%") } })
                        H2(SectionTitleStyle.toAttrs()) { Text(post!!.title) }
                        P(PropertyAddressStyle.toAttrs()) { Text(post!!.date) }
                        P(PropertyDetailStyle.toAttrs()) { Text(post!!.text) }
                    }
                }
            }
        }
        Footer()
    }
}

package xyz.malefic.gupta.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import xyz.malefic.gupta.styles.ThemedLinkStyle

@Composable
fun ThemedLink(
    path: String,
    text: String = path,
    modifier: Modifier = Modifier,
) {
    Link(
        path = path,
        text = text,
        modifier = ThemedLinkStyle.toModifier().then(modifier),
    )
}

package xyz.malefic.gupta.styles

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.s
import xyz.malefic.gupta.extension.background

val BlogPageStyle =
    CssStyle.base {
        Modifier
            .backgroundColor(Color("#f8f9fa"))
            .padding(4.cssRem, 2.cssRem)
            .minHeight(100.px)
    }

val BlogCardStyle =
    CssStyle {
        base {
            Modifier
                .backgroundColor(Color.white)
                .borderRadius(12.px)
                .boxShadow(0.px, 4.px, 20.px, color = rgba(0, 0, 0, 0.08))
                .padding(2.cssRem)
                .margin(bottom = 2.cssRem)
                .fillMaxWidth()
                .transition(Transition.of("box-shadow", duration = 0.3.s))
        }
        hover {
            Modifier.boxShadow(0.px, 8.px, 32.px, color = rgba(0, 0, 0, 0.15))
        }
    }

@Composable
fun BlogCardStyle(url: String): Modifier = BlogCardStyle.toModifier().then(Modifier.background(url))

val BlogImageStyle =
    CssStyle.base {
        Modifier
            .maxWidth(100.px)
            .borderRadius(8.px)
            .margin(bottom = 1.cssRem)
    }

val BlogButtonStyle =
    CssStyle {
        base {
            Modifier
                .backgroundColor(Color("#3498db"))
                .color(Color.white)
                .padding(0.7.cssRem, 1.5.cssRem)
                .borderRadius(6.px)
                .transition(Transition.of("background-color", duration = 0.3.s))
                .styleModifier { property("border", "none") }
        }
        hover {
            Modifier.backgroundColor(Color("#2980b9"))
        }
    }

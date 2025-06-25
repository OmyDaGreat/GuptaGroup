package xyz.malefic.gupta.styles

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backdropFilter
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
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
                .position(Position.Relative)
                .backgroundColor(Color.white)
                .borderRadius(12.px)
                .boxShadow(0.px, 4.px, 20.px, color = rgba(0, 0, 0, 0.08))
                .padding(2.cssRem)
                .margin(bottom = 2.cssRem)
                .fillMaxWidth()
                .maxWidth(600.px)
                .styleModifier {
                    property("margin-left", "auto")
                    property("margin-right", "auto")
                }.transition(Transition.of("box-shadow", duration = 0.3.s))
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
            .fillMaxWidth()
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
                .maxWidth(600.px)
                .fillMaxWidth()
                .styleModifier {
                    property("border", "none")
                    property("margin-left", "auto")
                    property("margin-right", "auto")
                    property("display", "block")
                }
        }
        hover {
            Modifier.backgroundColor(Color("#2980b9"))
        }
    }

val BlogCardOverlayStyle =
    CssStyle.base {
        Modifier
            .position(Position.Absolute)
            .fillMaxSize()
            .backgroundColor(rgba(5, 5, 5, 0.3))
            .zIndex(1)
            .borderRadius(12.px)
            .backdropFilter(blur(2.px))
    }

val BlogCardContentStyle =
    CssStyle.base {
        Modifier
            .position(Position.Relative)
            .zIndex(2)
            .color(Color.white)
            .padding(12.px)
    }

val BlogCardTitleStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(1.8.cssRem)
                .fontWeight(700)
                .color(blogTitleLight)
                .margin(bottom = 0.5.cssRem)
        }
    }

val BlogCardAddressStyle =
    CssStyle {
        base {
            Modifier
                .color(blogAddressGray)
                .margin(bottom = 1.cssRem)
                .fontSize(1.cssRem)
        }
    }

val BlogCardSummaryStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(0.9.cssRem)
                .color(blogSummaryLight)
                .fontWeight(500)
        }
    }

val ThemedLinkStyle =
    CssStyle {
        base {
            Modifier
                .color(babyblue)
                .fontWeight(600)
                .styleModifier { property("text-decoration", "none") }
                .transition(Transition.of("color", duration = 0.2.s))
        }
        hover {
            Modifier.color(bluegray)
        }
    }

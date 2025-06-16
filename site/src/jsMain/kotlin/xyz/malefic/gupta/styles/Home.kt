package xyz.malefic.gupta.styles

import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextShadow
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.backgroundPosition
import com.varabyte.kobweb.compose.ui.modifiers.backgroundSize
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.borderTop
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textShadow
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle.Companion.None
import org.jetbrains.compose.web.css.LineStyle.Companion.Solid
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.lineHeight
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.css.vh

val HeaderStyle =
    CssStyle.base {
        Modifier
            .fillMaxWidth()
            .backgroundColor(Color.white)
            .padding(1.cssRem, 2.cssRem)
            .boxShadow(0.px, 2.px, 4.px, color = rgba(0, 0, 0, 0.1))
    }

val LogoStyle =
    CssStyle {
        base {
            Modifier
                .margin(0.px)
                .fontSize(1.8.cssRem)
                .fontWeight(700)
                .color(bluegray)
        }
    }

val NavLinkStyle =
    CssStyle {
        base {
            Modifier
                .color(bluegray)
                .fontWeight(500)
                .fontSize(1.cssRem)
        }
    }

val HeroSectionStyle =
    CssStyle {
        base {
            Modifier
                .fillMaxWidth()
                .minHeight(100.vh)
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .justifyContent(JustifyContent.Center)
                .alignItems(AlignItems.Center)
                .textAlign(TextAlign.Center)
                .color(Color.white)
                .padding(2.cssRem)
        }
    }

val HeroTitleStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(3.5.cssRem)
                .fontWeight(700)
                .margin(bottom = 1.cssRem)
                .textShadow(TextShadow.of(2.px, 2.px, 4.px, rgba(0, 0, 0, 0.5)))
        }
    }

val HeroSubtitleStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(1.5.cssRem)
                .margin(bottom = 2.cssRem)
                .maxWidth(800.px)
                .styleModifier {
                    lineHeight("1.6")
                }
        }
    }

val HeroAgentInfoStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(1.2.cssRem)
                .margin(bottom = 3.cssRem)
        }
    }

val CTAButtonStyle =
    CssStyle {
        base {
            Modifier
                .color(Color.white)
                .border(0.px, None)
                .padding(1.cssRem, 2.cssRem)
                .fontSize(1.2.cssRem)
                .borderRadius(8.px)
                .cursor(Cursor.Pointer)
                .transition(Transition.of("background-color", 0.3.s))
                .backgroundColor(babyblue)
        }
        hover {
            Modifier.backgroundColor(Color("#2980b9"))
        }
    }

val SectionStyle =
    CssStyle.base {
        Modifier.padding(4.cssRem, 2.cssRem)
    }

val SectionTitleStyle =
    CssStyle {
        base {
            Modifier
                .textAlign(TextAlign.Center)
                .margin(bottom = 3.cssRem)
                .fontSize(2.5.cssRem)
                .color(bluegray)
        }
    }

val ContainerStyle =
    CssStyle {
        base {
            Modifier
                .maxWidth(1200.px)
                .margin(left = 0.px, right = 0.px)
        }
    }

val PropertyCardStyle =
    CssStyle {
        base {
            Modifier
                .backgroundColor(Color.white)
                .borderRadius(12.px)
                .overflow(Overflow.Hidden)
                .boxShadow(0.px, 4.px, 20.px, color = rgba(0, 0, 0, 0.1))
                .transition(Transition.of("transform", 0.3.s))
                .cursor(Cursor.Pointer)
        }
        hover {
            Modifier.transform { translateY((-10).px) }
        }
    }

val PropertyImageStyle =
    CssStyle.base {
        Modifier
            .height(250.px)
            .backgroundSize(BackgroundSize.Cover)
            .backgroundPosition(BackgroundPosition.of(CSSPosition.Center))
    }

val PropertyContentStyle =
    CssStyle.base {
        Modifier.padding(1.5.cssRem)
    }

val PropertyPriceStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(1.8.cssRem)
                .fontWeight(700)
                .color(bluegray)
                .margin(bottom = 0.5.cssRem)
        }
    }

val PropertyAddressStyle =
    CssStyle {
        base {
            Modifier
                .color(Color("#7f8c8d"))
                .margin(bottom = 1.cssRem)
                .fontSize(1.cssRem)
        }
    }

val PropertyDetailStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(0.9.cssRem)
                .color(Color("#95a5a6"))
                .fontWeight(500)
        }
    }

val NeighborhoodCardStyle =
    CssStyle {
        base {
            Modifier
                .backgroundColor(Color("#f8f9fa"))
                .borderRadius(12.px)
                .padding(2.cssRem)
                .textAlign(TextAlign.Center)
                .transition(Transition.all(0.3.s))
                .border(2.px, Solid, Color.transparent)
                .cursor(Cursor.Pointer)
        }
        hover {
            Modifier
                .backgroundColor(Color("#e9ecef"))
                .border {
                    color(babyblue)
                }
        }
    }

val NeighborhoodTitleStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(1.5.cssRem)
                .fontWeight(600)
                .color(bluegray)
                .margin(bottom = 1.cssRem)
        }
    }

val NeighborhoodDescriptionStyle =
    CssStyle {
        base {
            Modifier
                .color(Color("#7f8c8d"))
                .styleModifier {
                    lineHeight("1.6")
                }.fontSize(1.cssRem)
        }
    }

val NeighborhoodLinkStyle =
    CssStyle {
        base {
            Modifier
                .color(babyblue)
                .fontWeight(500)
                .fontSize(0.9.cssRem)
                .margin(top = 1.cssRem)
                .transition(Transition.of("color", 0.3.s))
        }
    }

val FooterStyle =
    CssStyle {
        base {
            Modifier
                .fillMaxWidth()
                .backgroundColor(bluegray)
                .color(Color.white)
                .padding(3.cssRem, 2.cssRem)
                .textAlign(TextAlign.Center)
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .alignItems(AlignItems.Center)
                .justifyContent(JustifyContent.Center)
        }
    }

val FooterTitleStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(1.5.cssRem)
                .margin(bottom = 1.cssRem)
        }
    }

val FooterDescriptionStyle =
    CssStyle {
        base {
            Modifier
                .fontSize(1.1.cssRem)
                .margin(bottom = 2.cssRem)
                .maxWidth(800.px)
                .margin(top = 0.px, bottom = 2.cssRem)
                .styleModifier {
                    lineHeight(1.6.toString())
                }
        }
    }

val ContactInfoContainerStyle =
    CssStyle {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .alignItems(AlignItems.Center)
                .justifyContent(JustifyContent.Center)
                .gap(0.5.cssRem)
        }
    }

val ContactIconStyle =
    CssStyle.base {
        Modifier.fontSize(1.2.cssRem)
    }

val FooterHRStyle =
    CssStyle {
        base {
            Modifier
                .margin(2.cssRem, 0.px)
                .border(0.px, None)
                .borderTop(1.px, Solid, Color("#34495e"))
        }
    }

val CopyrightStyle =
    CssStyle {
        base {
            Modifier
                .margin(0.px)
                .color(Color("#bdc3c7"))
        }
    }

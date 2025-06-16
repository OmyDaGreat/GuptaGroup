package xyz.malefic.gupta.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import xyz.malefic.gupta.extension.background
import xyz.malefic.gupta.styles.CTAButtonStyle
import xyz.malefic.gupta.styles.ContactIconStyle
import xyz.malefic.gupta.styles.ContactInfoContainerStyle
import xyz.malefic.gupta.styles.ContainerStyle
import xyz.malefic.gupta.styles.FooterDescriptionStyle
import xyz.malefic.gupta.styles.FooterStyle
import xyz.malefic.gupta.styles.FooterTitleStyle
import xyz.malefic.gupta.styles.HeaderStyle
import xyz.malefic.gupta.styles.HeroSectionStyle
import xyz.malefic.gupta.styles.HeroSubtitleStyle
import xyz.malefic.gupta.styles.HeroTitleStyle
import xyz.malefic.gupta.styles.LogoStyle
import xyz.malefic.gupta.styles.NavLinkStyle
import xyz.malefic.gupta.styles.PropertyAddressStyle
import xyz.malefic.gupta.styles.PropertyCardStyle
import xyz.malefic.gupta.styles.PropertyContentStyle
import xyz.malefic.gupta.styles.PropertyDetailStyle
import xyz.malefic.gupta.styles.PropertyImageStyle
import xyz.malefic.gupta.styles.PropertyPriceStyle
import xyz.malefic.gupta.styles.SectionStyle
import xyz.malefic.gupta.styles.SectionTitleStyle
import org.jetbrains.compose.web.dom.Footer as Foot

@Page
@Composable
@Suppress("unused")
fun HomePage() {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Header()
        HeroSection()
        FeaturedProperties()
        SocialSection()
        Footer()
    }
}

@Composable
fun Header() {
    Row(
        HeaderStyle.toModifier(),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically,
    ) {
        H1(LogoStyle.toAttrs()) {
            Text("Gupta Group")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(2.cssRem)) {
            NavLink("Home", "#")
            NavLink("Properties", "#properties")
            NavLink("About", "#about")
            NavLink("Contact", "#contact")
        }
    }
}

@Composable
fun NavLink(
    text: String,
    href: String,
) {
    Link(href, text, NavLinkStyle.toModifier())
}

@Composable
fun HeroSection() {
    Div(
        HeroSectionStyle
            .toModifier()
            .background("https://gallery.malefic.xyz/photos/Anime/Kubo/Earbuds.jpg")
            .toAttrs(),
    ) {
        H1(HeroTitleStyle.toAttrs()) { Text("Hero Section Title Placeholder") }
        P(HeroSubtitleStyle.toAttrs()) {
            Text("Hero section description placeholder text.")
        }
        P { Text("Social media links placeholder text.") }
        Button(CTAButtonStyle.toAttrs()) { Text("Call-to-action button placeholder") }
    }
}

@Composable
fun FeaturedProperties() {
    Section(
        SectionStyle
            .toModifier()
            .backgroundColor(Color("#f8f9fa"))
            .toAttrs(),
    ) {
        Div(ContainerStyle.toAttrs()) {
            H2(SectionTitleStyle.toAttrs()) {
                Text("Featured Properties Section Title Placeholder")
            }
            SimpleGrid(
                numColumns(base = 1, md = 2),
                Modifier.gap(2.cssRem),
            ) {
                PropertyCard(
                    image = "https://photos.zillowstatic.com/fp/72702e9f6fe74ae2707a21e460ef6960-cc_ft_960.webp",
                    link = "https://ruchikagupta.firstteam.com/home-search/listings/3231723333382174842-601-Olive-Avenue-l",
                    price = "$465,000",
                    address = "601 Olive Ave APT L, Long Beach, CA 90802",
                    beds = "2",
                    baths = "1",
                    sqft = "973",
                )
                PropertyCard(
                    image = "https://photos.zillowstatic.com/fp/56ee7813007a132c91d96916b1e6c377-cc_ft_960.webp",
                    link = "https://ruchikagupta.firstteam.com/home-search/listings/3231209707192205530-18147-Hearth-Drive",
                    price = "$978,000",
                    address = "18147 Hearth Drive, Fountain Valley, CA 92708",
                    beds = "2",
                    baths = "3",
                    sqft = "1,458",
                )
            }
        }
    }
}

@Composable
fun PropertyCard(
    image: String,
    link: String,
    price: String,
    address: String,
    beds: String,
    baths: String,
    sqft: String,
) {
    Div(PropertyCardStyle.toAttrs()) {
        Link(link) {
            Div(
                PropertyImageStyle
                    .toModifier()
                    .backgroundImage(url(image))
                    .toAttrs(),
            )
        }
        Div(PropertyContentStyle.toAttrs()) {
            H3(PropertyPriceStyle.toAttrs()) { Text(price) }
            P(PropertyAddressStyle.toAttrs()) { Text(address) }
            Row(horizontalArrangement = Arrangement.spacedBy(1.cssRem)) {
                PropertyDetail("$beds Beds")
                PropertyDetail("$baths Baths")
                PropertyDetail("$sqft Sq.Ft.")
            }
        }
    }
}

@Composable
fun PropertyDetail(text: String) {
    Span(PropertyDetailStyle.toAttrs()) { Text(text) }
}

@Composable
fun SocialSection() {
    Section(
        SectionStyle.toAttrs(),
    ) {
        Div(ContainerStyle.toAttrs()) {
            H2(SectionTitleStyle.toAttrs()) {
                Text("Social Section Title Placeholder")
            }
            Row(
                Modifier.gap(2.cssRem),
                Arrangement.Center,
            ) {
                SocialLink("Instagram", "https://instagram.com/Ruchika.Realtor")
                SocialLink("Facebook", "https://facebook.com/Ruchika.Realtor")
                SocialLink("TikTok", "https://tiktok.com/@Ruchika.Realtor")
            }
        }
    }
}

@Composable
fun SocialLink(
    platform: String,
    url: String,
) = Link(url, platform, NavLinkStyle.toModifier())

@Composable
fun Footer() {
    Foot(FooterStyle.toAttrs()) {
        Div(ContainerStyle.toAttrs()) {
            H3(FooterTitleStyle.toAttrs()) {
                Text("Ruchika Gupta | FirstTeam® Real Estate")
            }
            P(FooterDescriptionStyle.toAttrs()) {
                Text("Footer description placeholder text.")
            }
            Row(
                Modifier.gap(2.cssRem),
                Arrangement.Center,
            ) {
                ContactInfo("📧", "ruchikagupta@firstteam.com")
                ContactInfo("📞", "(714) 767-5752")
                ContactInfo("📍", "Orange County, CA")
            }
        }
    }
}

@Composable
fun ContactInfo(
    icon: String,
    text: String,
) {
    Div(ContactInfoContainerStyle.toAttrs()) {
        Span(ContactIconStyle.toAttrs()) {
            Text(icon)
        }
        Span { Text(text) }
    }
}

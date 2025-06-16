package xyz.malefic.gupta.extension

import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.backgroundPosition
import com.varabyte.kobweb.compose.ui.modifiers.backgroundSize

fun Modifier.background(
    image: String,
    size: BackgroundSize = BackgroundSize.Cover,
    position: BackgroundPosition = BackgroundPosition.of(CSSPosition.Center),
) = this
    .backgroundImage(url(image))
    .backgroundSize(size)
    .backgroundPosition(position)

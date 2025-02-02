package com.assem.loginformcompose.core.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.TextUnit
import com.assem.loginformcompose.ui.theme.LoginFormComposeTheme

@NonRestartableComposable
@Composable
fun MyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    textAlign: TextAlign? = null,
    textDecoration: TextDecoration? = null,
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        style = style,
        textAlign = textAlign
    )
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun TextPreview() {
    LoginFormComposeTheme(dynamicColor = false) {
        Column(modifier = Modifier.fillMaxSize()) {
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.displayLarge
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.displayMedium
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.displaySmall
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.headlineLarge
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.headlineMedium
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.headlineSmall
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.titleLarge
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.titleMedium
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.titleSmall
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.bodyLarge
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.bodyMedium
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.bodySmall
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.labelLarge
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.labelMedium
            )
            MyText(
                text = LoremIpsum(5).values.joinToString(" "),
                style = MaterialTheme.typography.labelSmall
            )
        }

    }
}
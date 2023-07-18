package com.alnazo.httpcatserrors.utils

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

@Composable
fun ClickableTextUrl(text: String, modifier: Modifier){
    val textLink = buildAnnotatedString {
        pushStringAnnotation(tag = "https://http.cat/", annotation = "https://http.cat/")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append(text)
            addStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline
                ),
                start = 0,
                end = text.length)
        }
        addStringAnnotation(
            tag = "URL",
            annotation = text,
            start = 0,
            end = text.length
        )
    }
    val urlHandler = LocalUriHandler.current

    ClickableText(
        text = textLink,
        modifier = modifier,
        onClick = {
            textLink
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { text ->
                    urlHandler.openUri(text.item)
                }
        }
    )

}
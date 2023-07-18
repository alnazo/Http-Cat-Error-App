package com.alnazo.httpcatserrors.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun SocialNetworktable(darkmode: Boolean? = false, image: Painter, imageDescriptor: String,image_dark: Painter? = null, imageDescriptor_dark: String? = null, url: String){
    Row(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .border(width = 1.dp, color = Color.Black)
            .padding(15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (darkmode == true && image_dark != null) {
            Image(
                painter = image_dark,
                contentDescription = imageDescriptor_dark,
                modifier = Modifier.height(25.dp)
            )
        } else {
            Image(
                painter = image,
                contentDescription = imageDescriptor,
                modifier = Modifier.height(25.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))
        ClickableTextUrl(
            text = url,
            modifier = Modifier.padding(vertical = 5.dp)
        )
    }
}
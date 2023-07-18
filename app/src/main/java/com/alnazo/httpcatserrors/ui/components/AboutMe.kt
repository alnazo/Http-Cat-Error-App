package com.alnazo.httpcatserrors.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alnazo.httpcatserrors.R
import com.alnazo.httpcatserrors.utils.ClickableTextUrl
import com.alnazo.httpcatserrors.utils.SocialNetworktable

@Preview(showBackground = true)
@Composable
fun AboutMe(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Text(stringResource(R.string.about_me))
        Spacer(modifier = Modifier.height(10.dp))
        Row(Modifier.fillMaxWidth()) {
            Image(painter = painterResource(R.drawable.alnazo), contentDescription = "Alnazo Logo")
            Column {
                Text(stringResource(R.string.me))
                Spacer(modifier = Modifier.height(12.dp))
                Text(stringResource(R.string.about_me_1))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(stringResource(R.string.project))
            ClickableTextUrl(
                text = "https://github.com/alnazo/Http-Cat-Error-App",
                modifier= Modifier.padding(vertical = 5.dp)
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(R.string.RRSS))
            Column(Modifier.padding(vertical = 15.dp)) {
                //Git Hub
                SocialNetworktable(
                    darkmode = isSystemInDarkTheme(),
                    image = painterResource(R.drawable.github_dark),
                    imageDescriptor = "GitHub Logo Dark",
                    image_dark = painterResource(R.drawable.github_white),
                    imageDescriptor_dark = "GitHub Logo White",
                    url = "https://github.com/alnazo"
                )

                //Twitter
                SocialNetworktable(
                    image = painterResource(R.drawable.twitter),
                    imageDescriptor = "Twitter Logo",
                    url = "https://twitter.com/Antonio3_96"
                )


                //Twitch
                SocialNetworktable(
                    image = painterResource(R.drawable.twitch),
                    imageDescriptor = "Twitch Logo",
                    url = "https://twitch.tv/alnazo"
                )

                //Youtube
                SocialNetworktable(
                    image = painterResource(R.drawable.youtube),
                    imageDescriptor = "Youtube Logo",
                    url = "https://www.youtube.com/@alnazo"
                )

                //TikTok
                SocialNetworktable(
                    image = painterResource(R.drawable.tiktok),
                    imageDescriptor = "TikTok Logo",
                    url = "https://www.tiktok.com/@antonio3_96"
                )

            }
        }
    }
}
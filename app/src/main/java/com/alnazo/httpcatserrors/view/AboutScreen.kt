package com.alnazo.httpcatserrors.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alnazo.httpcatserrors.R
import com.alnazo.httpcatserrors.ui.components.AboutMe
import com.alnazo.httpcatserrors.ui.components.SecondTopBar
import com.alnazo.httpcatserrors.utils.ClickableTextUrl

@Composable
fun AboutScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            SecondTopBar(navController = navController, textLayout =  stringResource(id = R.string.about))
        }
    ) {
        paddingValues -> BodyAboutContent(paddingValues)
    }
}

@Composable
fun BodyAboutContent(modifier: PaddingValues){
    Column(
        Modifier
            .padding(modifier)
            .fillMaxSize()) {
        AboutContent()
    }
}

@Preview(showSystemUi = true)
@Composable
fun AboutContent() {
    Column(Modifier.padding(12.dp)) {

        Text(stringResource(R.string.about_app_1), Modifier.padding(vertical = 8.dp))
        Text(stringResource(R.string.about_app_2), Modifier.padding(vertical = 8.dp))
        ClickableTextUrl("https://http.cat/",
            Modifier
                .padding(vertical = 5.dp)
                .align(Alignment.CenterHorizontally))
        Text(stringResource(R.string.about_app_3), Modifier.padding(vertical = 8.dp))

        AboutMe()
    }
}

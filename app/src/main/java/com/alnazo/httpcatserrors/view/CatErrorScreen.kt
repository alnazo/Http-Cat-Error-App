package com.alnazo.httpcatserrors.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.alnazo.httpcatserrors.R
import com.alnazo.httpcatserrors.models.getHttpCat
import com.alnazo.httpcatserrors.ui.components.SecondTopBar

@Composable
fun CatErrorScreen(navController: NavHostController, id: Int){
    Scaffold(
        topBar = {
            SecondTopBar(navController = navController, textLayout = stringResource(id = R.string.cat_error) + " - $id")
        }
    ) {
        paddingValues -> BodyCatContent(paddingValues, id)

    }
}

@Composable
fun BodyCatContent(modifier: PaddingValues, id: Int){
    val cat = getHttpCat(id)
    Row(Modifier.padding(modifier).fillMaxSize()) {
        AsyncImage(
            model = cat.image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
    }

}
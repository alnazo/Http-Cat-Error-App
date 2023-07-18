package com.alnazo.httpcatserrors.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.alnazo.httpcatserrors.R
import com.alnazo.httpcatserrors.models.CatsHttpError
import com.alnazo.httpcatserrors.models.getHttpCats
import com.alnazo.httpcatserrors.navigation.AppScreen
import com.alnazo.httpcatserrors.ui.components.MainTopBar

@Composable
fun MainScreen(navController: NavHostController) {
    var cats = getHttpCats()
    Scaffold(
        topBar = { MainTopBar(navController, stringResource(id = R.string.app_name), cats) }
    ) {
        paddingValues -> BodyContent(navController, paddingValues, cats)

    }
}

@Composable
fun BodyContent(navController: NavHostController, paddingValues: PaddingValues, cats: List<CatsHttpError>){
    LazyVerticalGrid(
        contentPadding = paddingValues,
        columns = GridCells.Adaptive(150.dp)
    ) {
        items(cats) { cat ->
            CatErrorItem(navController, cat, Modifier.padding(2.dp))
        }
    }
}

@Composable
fun CatErrorItem(navController: NavHostController, cat: CatsHttpError, modifier: Modifier) {
    Column(modifier = modifier) {
        Box(modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
        ) {
            AsyncImage(
                model = cat.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clickable {
                        navController.navigate(AppScreen.CatErrorScreen.route + "/${cat.id}")
                    },
                contentScale = ContentScale.Crop
            )
        }
    }
}

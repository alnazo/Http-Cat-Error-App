package com.alnazo.httpcatserrors.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alnazo.httpcatserrors.R
import com.alnazo.httpcatserrors.models.CatsHttpError
import com.alnazo.httpcatserrors.navigation.AppScreen
import com.alnazo.httpcatserrors.view.BodyContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(navController: NavHostController, title: String, cats: List<CatsHttpError>){
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    if (!active) {
        TopAppBar(
            title = { Text(title) },
            actions = {
                IconButton(onClick = {
                    active = true
                }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
                IconButton(onClick = {
                    navController.navigate(AppScreen.AboutScreen.route)
                }) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = null)

                }
            }
        )
    } else {
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = {
                active = false
            },
            active = active,
            onActiveChange = { active = it },
            modifier = Modifier.wrapContentHeight(),
            placeholder = { Text(stringResource(R.string.search)) },
            trailingIcon = {
                IconButton(onClick = { active = false }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            query = ""
                            active = false
                        })
                }
            }
        ){
            var filtcats = cats.filter { it.title.contains(query, true) }
            BodyContent(navController, PaddingValues(10.dp), filtcats)
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondTopBar(navController: NavHostController, textLayout: String){
    TopAppBar(
        title = {
            Row() {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .clickable {
                            navController.popBackStack()
                        }
                        .padding(top = 5.dp))
                Spacer(Modifier.width(8.dp))
                Text(textLayout)
            }
        }
    )
}

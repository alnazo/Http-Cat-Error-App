package com.alnazo.httpcatserrors.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.alnazo.httpcatserrors.R
import com.alnazo.httpcatserrors.navigation.AppScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){

    LaunchedEffect(key1 = true){
        delay(2000)
        navController.popBackStack()
        navController.navigate(AppScreen.MainScreen.route)
    }

    Splash()

}

@Composable
fun Splash(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.alnazo),
            contentDescription = "Logo Alnazo",
            Modifier.size(150.dp, 150.dp))
        Text(
            text = stringResource(R.string.welcome),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }

}


@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview(){
    Splash()
}
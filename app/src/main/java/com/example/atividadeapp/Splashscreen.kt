package com.example.atividadeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atividadeapp.ui.theme.ATividadeAppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    // Aqui você poderia usar LaunchedEffect + delay(2000L) para aguardar 2s
    LaunchedEffect(Unit) {
        delay(2000L)
        onTimeout()
    }

    Box(Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.logo_games),
            contentDescription = "Logo",
            modifier = Modifier
                .size(600.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    ATividadeAppTheme {
        SplashScreen(onTimeout = {})
    }
}
package com.example.atividadeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.atividadeapp.ui.theme.ATividadeAppTheme
import com.example.atividadeapp.ui.theme.exo2FontFamily

@Composable
fun TelaEscolhaGenero(navController: NavController, plataforma: String) {

    val isDarkTheme = isSystemInDarkTheme()
    val voltarIcon = if (isDarkTheme) {
        R.drawable.bot_o_voltar
    } else {
        R.drawable.bot_o_vol_preto
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Fundo de tijolos

        // Botão de voltar
        Image(
            painter = painterResource(voltarIcon),
            contentDescription = "Voltar",
            modifier = Modifier
                .padding(40.dp)
                .size(50.dp)
                .align(Alignment.TopStart)
                .clickable {
                    navController.popBackStack()// volta para a tela que eu estava antes
                }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, bottom = 16.dp)

        ) {
            Text(
                text = "Escolha\no \nGênero",
                fontSize = 24.sp,
               // fontFamily = exo2FontFamily,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground // muda conforme o tema
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-170).dp)
        ) {
            Botaogenero("Battle Royale") {
                navController.navigate("${plataforma}_battle")
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-40).dp)
        ) {
            Botaogenero("Aventura") {
                navController.navigate("${plataforma}_aventura")
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (100).dp)
        ) {
            Botaogenero("Com Amigos") {
                navController.navigate("${plataforma}_com_amigos")
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (220).dp)
        ) {
            Botaogenero("Aleatório") {
                navController.navigate("${plataforma}_aleatorio")
            }
        }
    }
}

@Composable
fun Botaogenero(texto: String, onClick: () -> Unit = {}) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 10.dp)
    ) {
        Spacer(modifier = Modifier.width(100.dp))

        // Botão com clique somente aqui
        Box(
            modifier = Modifier
                .height(60.dp)
                .width(220.dp)
                .border(3.dp, Color(0xFFFFFFFF), RoundedCornerShape(50)) // ⬅️ Borda do botão
                .background(Color.Black, RoundedCornerShape(50))
                .clickable(onClick = onClick), // ⬅️ Clique só aqui!
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = texto,
                textAlign = TextAlign.Center,
               fontFamily = exo2FontFamily,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewTelaEscolhaGenero() {
    ATividadeAppTheme {
        TelaEscolhaGenero(
            navController = rememberNavController(), 
            plataforma = "Celular"
        )
    }
}

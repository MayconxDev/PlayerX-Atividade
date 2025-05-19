package com.example.atividadeapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun TelaInicial(navController: NavController) {

    Box(Modifier.fillMaxSize()) {


        // Logo no topo
        Image(
            painter = painterResource(R.drawable.logo_games),
            contentDescription = "Logo",
            modifier = Modifier
                .width(700.dp)              // Define a largura como 300 dp (você pode mudar o valor)
                .height(400.dp)             // Define a altura como 200 dp (você pode mudar o valor)
                .align(Alignment.TopCenter)   // Alinha ao topo e à esquerda
                .padding(top = 16.dp)        // Adiciona um pequeno espaço do topo
        )

        // Texto centralizado sobre a logo
        Text(
            text = "Bem-vindo ao PlayerX! \nDê fim ao tédio!",
            fontSize = 30.sp,    // tamanho da fonte
            lineHeight = 40.sp, //epaçamento do texto
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onBackground // muda conforme o tema
            ),
            textAlign = TextAlign.Center, // 🔥 Centraliza o texto dentro da largura
            modifier = Modifier
                .fillMaxWidth() // 🔥 Para o textAlign funcionar
                .align(Alignment.Center) // alinha ao centro
                .offset(y = (25).dp),  // desloca o texto para baixo
        )
        // Botão Play" na parte inferior
        BotaoTeladeInicio(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 200.dp), // espaço da margem inferior
            onClick = {
                navController.navigate("escolha_jogo") }
        )
    }
}

@Composable
fun BotaoTeladeInicio(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(60.dp), // bordas arredondadas
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        border = BorderStroke(3.dp, Color(0xFFFFFFFF)), // roxo personalizado
        modifier = modifier
            .width(200.dp)     // largura fixa
            .height(60.dp)     // altura fixa
    ) {
        Text(
            "PLAY",
            fontSize = 25.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,


        )
    }
}
@Composable
@Preview(showBackground = true)
fun TelaInicialPreview() {
    // TelaInicial(navController = rememberNavController())
        TelaInicial(navController = rememberNavController())

}
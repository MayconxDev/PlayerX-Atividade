package com.example.atividadeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.atividadeapp.ui.theme.borderColor

data class Celularaventura(
    val nome: String,
    val descricao: String,
    val imagemResId: Int
)

val aventuracelular = listOf(
    Celularaventura("Genshin Impact", "Um RPG de ação em mundo aberto com gráficos impressionantes e jogabilidade envolvente.", R.drawable.guenshin_impact),
    Celularaventura("Stardew Valley", "Um simulador de fazenda com elementos de RPG e exploração.", R.drawable.stardew_valley),
    Celularaventura("Minecraft", "Um jogo de construção e sobrevivência em um mundo gerado aleatoriamente.", R.drawable.minecraft),
    Celularaventura("Terraria", "Um jogo de aventura em 2D com exploração, construção e combate.", R.drawable.terraria),
    Celularaventura("limbo", "Um jogo de plataforma e quebra-cabeça com uma atmosfera sombria e envolvente.", R.drawable.limbo),
    Celularaventura("Sky: Filhos da Luz", "Um jogo de aventura social em um mundo aberto, onde os jogadores exploram e resolvem quebra-cabeças juntos.", R.drawable.sky),
)

@Composable
fun AventuraCelular(navController: NavController) {
    var actventry by remember { mutableStateOf(aventuracelular.random()) }

    val isDarkTheme = isSystemInDarkTheme()
    val voltarIcon = if (isDarkTheme) {
        R.drawable.bot_o_voltar
    } else {
        R.drawable.bot_o_vol_preto
    }
    // Escolhe um jogo aleatório

    Box(modifier = Modifier.fillMaxSize()) {
        // Fundo

        // Botão voltar
        Image(
            painter = painterResource(voltarIcon),
            contentDescription = "Voltar",
            modifier = Modifier
                .padding(40.dp)
                .size(50.dp)
                .align(Alignment.TopStart)
                .clickable {
                    navController.popBackStack()
                }
        )

        // Conteúdo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            // Nome do jogo
            Text(
                text = actventry.nome,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            val borderColor = MaterialTheme.colorScheme.borderColor
            // Imagem do jogo
            Image(
                painter = painterResource(actventry.imagemResId),
                contentDescription = actventry.nome,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .border(3.dp, borderColor, shape = RoundedCornerShape(50.dp)) // Borda branca
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Descrição do jogo
            Text(
                text = actventry.descricao,
                fontSize = 24.sp,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground // muda conforme o tema
                ),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier
                    .offset(y = (140).dp)
            ) {
                Botaogenero("Trocar Jogo") {
                    actventry = aventuracelular.random()

                }
            }
        }
    }
}

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.atividadeapp.ui.theme.borderColor


// 1. Data class para representar um jogo
data class Jogo(
    val nome: String,
    val descricao: String,
    val imagemResId: Int
)

// 2. Lista de jogos (você pode colocar isso fora do Composabl  e)
val jogosMobile = listOf(
    Jogo("Call of Duty Mobile", "Tiro rápido com multiplayer e battle royale.", R.drawable.codazada),
    Jogo("Garena Delta Force", "Novo battle royale com gráficos realistas.", R.drawable.deltaforce),
    Jogo("PUBG Mobile", "Combate realista com estratégia em mapas enormes.", R.drawable.pubg),
    Jogo("Clash Royale", "Estratégia em tempo real com cartas e batalhas.", R.drawable.clash_royale),
    Jogo("Free Fire", "Battle royale rápido com partidas de 10 minutos.", R.drawable.free_fire),
    Jogo("Clash of Clans", "Estratégia em tempo real com construção de vilas.", R.drawable.clashofclans),
    Jogo("Ea fc mobile", "Futebol com times reais e jogabilidade rápida.", R.drawable.eafcmobile),
    Jogo("Brawl Stars", "Luta em equipe com personagens únicos e modos variados.", R.drawable.brawl_stars),
    Jogo("8Ball Pool", "Sinuca online com partidas rápidas e desafiadoras.", R.drawable.billiards),
    Jogo ("Real Racing 3", "Corridas realistas com gráficos impressionantes e carros reais.", R.drawable.real_racing_3),
    Jogo("Asphalt 9", "Corridas emocionantes com carros de luxo e gráficos incríveis.", R.drawable.asphaut9),
    Jogo("Rfs", "Simulador de voo com aeronaves reais e gráficos impressionantes.", R.drawable.rfs),
    Jogo("Roblox", "Plataforma de jogos online com criação e compartilhamento de jogos.", R.drawable.roblox),
    Jogo("Soul Knight", "Ação e aventura em um mundo pixelado com elementos de RPG.", R.drawable.soul_knight),
    Jogo ("Subway Surfers", "Corrida infinita em trilhos com gráficos vibrantes.", R.drawable.subway_surfers),
    Jogo("Candy Crush Saga", "Quebra-cabeça viciante com doces e desafios.", R.drawable.candy_crush),
    Jogo("Mobile Legends", "MOBA com batalhas em equipe e heróis únicos.", R.drawable.mobile_legends),

)

@Composable
fun CelularAleatorioooo(navController: NavController) {
    var jogosAleatorios by remember { mutableStateOf( jogosMobile.random()) }

    val isDarkTheme = isSystemInDarkTheme()
    val voltarIcon = if (isDarkTheme) {
        R.drawable.bot_o_voltar
    } else {
        R.drawable.bot_o_vol_preto
    }

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
            // Título
            Spacer(modifier = Modifier.height(70.dp))
            // Nome do jogo
            Text(
                text = jogosAleatorios.nome,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            val borderColor = MaterialTheme.colorScheme.borderColor
            // Imagem do jogo
            Image(
                painter = painterResource(jogosAleatorios.imagemResId),
                contentDescription = jogosAleatorios.nome,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .border(3.dp, borderColor, shape = RoundedCornerShape(50.dp)) // Borda branca

            )

            Spacer(modifier = Modifier.height(16.dp))

            // Descrição do jogo
            Text(
                text = jogosAleatorios.descricao,
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
                    jogosAleatorios = jogosMobile.random()

                }
            }
        }
    }
}

@Preview
@Composable
fun prevs() {
    CelularAleatorioooo(
        navController = rememberNavController()
    )
}

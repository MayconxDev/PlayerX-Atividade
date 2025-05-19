package com.example.atividadeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.atividadeapp.ui.theme.ATividadeAppTheme
import com.example.atividadeapp.ui.theme.borderColor

data class PcBattleRoyalle(
    val nome: String,
    val descricao: String,
    val imagemResId: Int
)

val battleComputer = listOf(
    PcBattleRoyalle("Call of Duty Warzone", "Um jogo de tiro gratuito para com modos multiplayer e battle royale." +
            " Traz mapas, armas e personagens clássicos da franquia Call of Duty, com gráficos de alta qualidade e jogabilidade rápida", R.drawable.warzone),
    PcBattleRoyalle("Fortnite", "Um jogo de tiro em terceira pessoa com um estilo de arte vibrante e jogabilidade única." +
            " Os jogadores podem construir estruturas enquanto lutam, oferecendo uma experiência de combate dinâmica e estratégica.", R.drawable.fortnited),
    PcBattleRoyalle("Valorant", "Um jogo de tiro tático em primeira pessoa que combina elementos de jogos de tiro com habilidades únicas de personagens." +
            " Os jogadores formam equipes e competem em partidas estratégicas, utilizando tanto armas quanto habilidades especiais.", R.drawable.valorant_image),
    PcBattleRoyalle("Apex Legends", "Um jogo de tiro em primeira pessoa com elementos de battle royale, onde os jogadores escolhem lendas com habilidades únicas." +
            " O jogo se destaca por sua jogabilidade rápida, mecânicas de movimento fluidas e um sistema de ping inovador.", R.drawable.apex),
    PcBattleRoyalle("PUBG", "Um dos primeiros jogos de battle royale, onde até 100 jogadores competem para ser o último sobrevivente em um mapa grande.", R.drawable.pubg),
    PcBattleRoyalle("Overwatch", "Um jogo de tiro em equipe com heróis únicos, cada um com habilidades especiais." +
            " Os jogadores formam equipes e competem em modos de jogo variados, combinando estratégia e ação rápida.", R.drawable.overwhat),
    PcBattleRoyalle("Rainbow Six Siege", "Um jogo de tiro tático em primeira pessoa focado em combate entre equipes." +
            " Os jogadores assumem o papel de operadores com habilidades únicas e devem trabalhar em equipe para completar objetivos.", R.drawable.raibow),
)

@Composable
fun ComputadorBattle(navController: NavController) {
    var pcbatle by remember { mutableStateOf(battleComputer.random()) }
    val isDarkTheme = isSystemInDarkTheme()
    val voltarIcon = if (isDarkTheme) {
        R.drawable.bot_o_voltar
    } else {
        R.drawable.bot_o_vol_preto
    }

    Box(modifier = Modifier.fillMaxSize()

    ) {
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
    }
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
            text = pcbatle.nome,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        val borderColor = MaterialTheme.colorScheme.borderColor
        // Imagem do jogo
        Image(
            painter = painterResource(pcbatle.imagemResId),
            contentDescription = pcbatle.nome,
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(14.dp))
                .border(3.dp, borderColor, shape = RoundedCornerShape(50.dp)) // Borda branca
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Descrição do jogo
        Text(
            text = pcbatle.descricao,
            fontSize = 24.sp,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
                        textAlign = TextAlign.Center,
            lineHeight = 24.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(modifier = Modifier.fillMaxSize()
            .offset(x = 60.dp)) {
            Botaogenero("Trocar Jogo") {
                pcbatle = battleComputer.random()

            }
        }
    }
}

@Preview
@Composable
fun TelacomPreview() {
    ATividadeAppTheme {
        ComputadorBattle (navController = rememberNavController())
    }
}

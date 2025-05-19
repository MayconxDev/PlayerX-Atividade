package com.example.atividadeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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

data class CelularBattleRoyalle(
    val nome: String,
    val descricao: String,
    val imagemResId: Int
)

val battleCelular = listOf(
    CelularBattleRoyalle("Call of Duty Mobile", "Um jogo de tiro gratuito para celular com modos multiplayer e battle royale." +
            " Traz mapas, armas e personagens clássicos da franquia Call of Duty, com gráficos de alta qualidade e jogabilidade rápida..", R.drawable.codazada),
    CelularBattleRoyalle("Garena Delta Force", "O jogo traz gráficos atualizados, modos multiplayer e missões táticas inspiradas em operações" +
            " militares reais, focando em trabalho em equipe, estratégia e ação intensa. Ele busca equilibrar jogabilidade rápida com realismo militar..", R.drawable.deltaforce),
    CelularBattleRoyalle("PUBG Mobile", " um jogo Battle Royale gratuito para celular, onde até 100 jogadores lutam em mapas extensos para ser o " +
            "último sobrevivente. Ele é conhecido por sua jogabilidade estratégica, variedade de armas, veículos e modos de jogo, combinando ação intensa com momentos de tensão tática..", R.drawable.pubg),
    CelularBattleRoyalle("Critical Ops", " um jogo de tiro em primeira pessoa (FPS) para celular focado em combates rápidos e estratégicos entre equipes." +
            " Com visuais limpos e jogabilidade competitiva, ele lembra clássicos como Counter-Strike, oferecendo modos como desarmar a bomba, mata-mata em equipe e duelo de armas.", R.drawable.criticalops),
    CelularBattleRoyalle("Stand Off 2", "um jogo de tiro em primeira pessoa (FPS) gratuito para dispositivos móveis, desenvolvido pela Axlebolt. Inspirado em " +
            "clássicos como Counter-Strike, oferece partidas online intensas com foco em habilidade e estratégia.", R.drawable.standoff2),
)

@Composable
fun CelularBattle(navController: NavController) {
    var jogoAtual by remember { mutableStateOf(battleCelular.random()) }

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
                text = jogoAtual.nome,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            val borderColor = MaterialTheme.colorScheme.borderColor
            // Imagem do jogo
            Image(
                painter = painterResource(jogoAtual.imagemResId),
                contentDescription = jogoAtual.nome,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .border(3.dp, borderColor, shape = RoundedCornerShape(50.dp)) // Borda branca
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Descrição do jogo
            Text(
                text = jogoAtual.descricao,
                fontSize = 24.sp,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground // muda conforme o tema
                ),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Box(modifier = Modifier.fillMaxSize()
                .offset(x = 60.dp)) {
                Botaogenero("Trocar Jogo") {
                    jogoAtual = battleCelular.random()

                }
            }
        }
    }

@Preview
@Composable
fun TelaCelulaPreview() {
    ATividadeAppTheme {
        CelularBattle(navController = rememberNavController())
    }
}

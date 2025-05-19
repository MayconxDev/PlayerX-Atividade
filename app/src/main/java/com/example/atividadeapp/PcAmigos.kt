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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.atividadeapp.ui.theme.borderColor

data class PcAmigos(
    val nome: String,
    val descricao: String,
    val imagemResId: Int
)

val friendspc = listOf(
    PcAmigos("League of Legends", "Um jogo de estratégia em equipe onde dois times competem para destruir a base do outro.", R.drawable.leagueoflegends),
    PcAmigos("Dota 2", "Um jogo de estratégia em equipe onde dois times competem para destruir a base do outro.", R.drawable.dota2),
    PcAmigos("Sea of Thieves", "Um jogo de aventura em mundo aberto onde você joga como um pirata em busca de tesouros e aventuras.", R.drawable.seaofthieves),
    PcAmigos("Overcooked 2", "Um jogo de cozinha cooperativo onde você e seus amigos devem preparar pratos em cozinhas malucas.", R.drawable.overcooked2),
    PcAmigos("Rocket League", "Um jogo de futebol com carros onde você e seus amigos competem em partidas emocionantes.", R.drawable.rocketleague),
    PcAmigos("Fall Guys", "Um jogo de festa multiplayer onde você compete em minijogos malucos para ser o último sobrevivente.", R.drawable.fallguys),
    PcAmigos("Forza Horizon 5", "Um jogo de corrida em mundo aberto onde você pode explorar o México e competir em diversas corridas.", R.drawable.forzahorizon5),
    PcAmigos("Ark: Survival Evolved", "Um jogo de sobrevivência em mundo aberto onde você deve sobreviver em uma ilha cheia de dinossauros e criaturas pré-históricas.", R.drawable.ark),
)


@Composable
fun PcComAmigos(navController: NavController) {
    // Implementação da tela "PC com amigos"
        var pcmigos by remember { mutableStateOf(friendspc.random()) }
        val isDarkTheme = isSystemInDarkTheme()
        val voltarIcon = if (isDarkTheme) {
            R.drawable.bot_o_voltar
        } else {
            R.drawable.bot_o_vol_preto
        }

        Box(modifier = Modifier.fillMaxSize()) {

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
                text = pcmigos.nome,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            val borderColor = MaterialTheme.colorScheme.borderColor
            // Imagem do jogo
            Image(
                painter = painterResource(pcmigos.imagemResId),
                contentDescription = pcmigos.nome,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .border(3.dp, borderColor, shape = RoundedCornerShape(50.dp)) // Borda branca
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Descrição do jogo
            Text(
                text = pcmigos.descricao,
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
                    pcmigos = friendspc.random()

                }
            }
        }
    }

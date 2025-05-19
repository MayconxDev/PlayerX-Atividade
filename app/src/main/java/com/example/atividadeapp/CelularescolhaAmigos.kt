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

data class Celularamigos(
    val nome: String,
    val descricao: String,
    val imagemResId: Int
)

val amigoscelular = listOf(
    //Celularamigos("Among Us", "Um jogo de dedução social onde os jogadores tentam descobrir quem é o impostor.", R.drawable.amongus),
    Celularamigos("Minecraft", "Um jogo de construção e sobrevivência em um mundo gerado aleatoriamente.", R.drawable.minecraft),
    Celularamigos("Soul Knight", "Um jogo de ação e aventura com elementos de RPG, onde os jogadores exploram masmorras e lutam contra inimigos.", R.drawable.soul_knight),
    Celularamigos("Brawl Stars", "Um jogo de batalha em equipe com personagens únicos e modos variados.", R.drawable.brawl_stars),
    Celularamigos("PUBG Mobile", "Um jogo de battle royale onde os jogadores lutam para ser o último sobrevivente.", R.drawable.pubg),
    Celularamigos("Among Us", "Um jogo de dedução social onde os jogadores tentam descobrir quem é o impostor.", R.drawable.amongus),
    Celularamigos("Stambleguys", "Um jogo de festa online onde os jogadores competem em minijogos divertidos e caóticos.", R.drawable.stumbleguys),



)
@Composable
fun JogarAmigos(navController: NavController){
    var amigos by remember { mutableStateOf(amigoscelular.random()) }

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
            text = amigos.nome,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        val borderColor = MaterialTheme.colorScheme.borderColor
        // Imagem do jogo
        Image(
            painter = painterResource(amigos.imagemResId),
            contentDescription = amigos.nome,
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(14.dp))
                .border(3.dp, borderColor, shape = RoundedCornerShape(50.dp)) // Borda branca
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Descrição do jogo
        Text(
            text = amigos.descricao,
            fontSize = 24.sp,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onBackground),
                        textAlign = TextAlign.Center,
            lineHeight = 24.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(modifier = Modifier.fillMaxSize()
            .offset(x = 60.dp)) {
            Botaogenero("Trocar Jogo") {
                amigos = amigoscelular.random()

            }
        }
    }
}

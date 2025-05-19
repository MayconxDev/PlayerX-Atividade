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

data class Pcaleatorio(
    val nome: String,
    val descricao: String,
    val imagemResId: Int
)

val aleariopc = listOf(
    Pcaleatorio("Call of Duty Warzone", "Um jogo de tiro gratuito para com modos multiplayer e battle royale." +
            " Traz mapas, armas e personagens clássicos da franquia Call of Duty, com gráficos de alta qualidade e jogabilidade rápida", R.drawable.warzone),
    Pcaleatorio("Fortnite", "Um jogo de tiro em terceira pessoa com um estilo de arte vibrante e jogabilidade única." +
            " Os jogadores podem construir estruturas enquanto lutam, oferecendo uma experiência de combate dinâmica e estratégica.", R.drawable.fortnited),
    Pcaleatorio("Valorant", "Um jogo de tiro tático em primeira pessoa que combina elementos de jogos de tiro com habilidades únicas de personagens." +
            " Os jogadores formam equipes e competem em partidas estratégicas, utilizando tanto armas quanto habilidades especiais.", R.drawable.valorant_image),
    Pcaleatorio("Apex Legends", "Um jogo de tiro em primeira pessoa com elementos de battle royale, onde os jogadores escolhem lendas com habilidades únicas." +
            " O jogo se destaca por sua jogabilidade rápida, mecânicas de movimento fluidas e um sistema de ping inovador.", R.drawable.apex),
    Pcaleatorio("PUBG", "Um dos primeiros jogos de battle royale, onde até 100 jogadores competem para ser o último sobrevivente em um mapa grande.", R.drawable.pubg),
    Pcaleatorio("Overwatch", "Um jogo de tiro em equipe com heróis únicos, cada um com habilidades especiais." +
            " Os jogadores formam equipes e competem em modos de jogo variados, combinando estratégia e ação rápida.", R.drawable.overwhat),
    Pcaleatorio("Rainbow Six Siege", "Um jogo de tiro tático em primeira pessoa focado em combate entre equipes." +
            " Os jogadores assumem o papel de operadores com habilidades únicas e devem trabalhar em equipe para completar objetivos.", R.drawable.raibow),
    Pcaleatorio("The Witcher 3: Wild Hunt", "Um RPG de ação em mundo aberto, onde você joga como Geralt de Rivia, um caçador de monstros em busca de sua filha adotiva.", R.drawable.thewitcher),
    Pcaleatorio("Minecraft", "Um jogo de construção e sobrevivência em um mundo gerado aleatoriamente.", R.drawable.minecraft),
    Pcaleatorio("black myth wukong", "Um jogo de ação e aventura baseado na lenda do Rei Macaco, onde você luta contra inimigos e explora um mundo rico em mitologia chinesa.", R.drawable.blackmith),
    Pcaleatorio("Dark Souls III", "Um RPG de ação desafiador, onde você enfrenta inimigos poderosos e explora um mundo sombrio cheio de segredos.", R.drawable.darksouls),
    Pcaleatorio("Sekiro: Shadows Die Twice", "Um jogo de ação e aventura em terceira pessoa, onde você joga como um samurai em busca de vingança em um mundo japonês feudal.", R.drawable.sekiro),
    Pcaleatorio("Horizon Zero Dawn", "Um RPG de ação em mundo aberto, onde você joga como Aloy, uma caçadora em um mundo pós-apocalíptico dominado por máquinas.", R.drawable.horizon),
    Pcaleatorio("Assassin's Creed Valhalla", "Um jogo de ação e aventura em mundo aberto, onde você joga como Eivor, um viking que explora a Inglaterra e Noruega.", R.drawable.assassinscreed),
    Pcaleatorio("Cyberpunk 2077", "Um RPG de ação em mundo aberto ambientado em um futuro distópico, onde você joga como V, um mercenário em busca de imortalidade.", R.drawable.cyberpunk),
)

@Composable
fun PcAleatorio(navController: NavController) {
    var pctorio by remember { mutableStateOf(aleariopc.random()) }
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
            text = pctorio.nome,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        val borderColor = MaterialTheme.colorScheme.borderColor
        // Imagem do jogo
        Image(
            painter = painterResource(pctorio.imagemResId),
            contentDescription = pctorio.nome,
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(14.dp))
                .border(3.dp, borderColor, shape = RoundedCornerShape(50.dp)) // Borda branca
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Descrição do jogo
        Text(
            text = pctorio.descricao,
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
                pctorio = aleariopc.random()

            }
        }
    }
}

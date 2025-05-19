package com.example.atividadeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.atividadeapp.ui.theme.exo2FontFamily
import com.example.atividadeapp.ui.theme.fontzada


@Composable
fun TelaEscolhaJogo(navController: NavController) {
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
                    navController.popBackStack()
                }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, bottom = 16.dp)

        ) {
            Text(
                text = "Selecione\nonde vai\nJogar",
                fontSize = 24.sp,
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
                .offset(y = (-100).dp)
        ) {
            // Botões
            Botaogenero("Celular") {
                navController.navigate("escolha_genero/celular")
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (100).dp)
        ) {
            Botaogenero("Computador") {
                navController.navigate("escolha_genero/PC")
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (140).dp)
        ) {
           // Botaogenero("Console") {
                // navController.navigate("escolha_genero/console")
            }
            // Correção em TelaEscolhaJogo: Removido botão duplicado
        }
    }



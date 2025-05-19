package com.example.atividadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.atividadeapp.ui.theme.ATividadeAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Método chamado quando a atividade é criada
        super.onCreate(savedInstanceState) // Chama o método da superclasse
        enableEdgeToEdge()
        setContent {
            ATividadeAppTheme {      // Tema da aplicação
                val navController = rememberNavController() // Criar o NavController
                NavHost(navController, startDestination = "splash") { //
                    composable("splash") {
                        SplashScreen { // função da splshScreen
                            navController.navigate("home") {
                                // Navega para a tela inicial
                                popUpTo("splash") {
                                    inclusive = true
                                } // deixa a tela de splash na pilha
                                // Remove a tela de splash da pilha de navegação
                                // Limpa a pilha de navegação

                            }
                        }
                    }
                    composable("escolha_jogo") { TelaEscolhaJogo(navController) }
                    // Passando o navController para a TelaEscolhaJogo
                    composable("home") { TelaInicial(navController) }
                    // Passando o navController para a TelaInicial
                    composable("escolha_genero/{plataforma}") { backStackEntry ->
                        val plataforma = backStackEntry.arguments?.getString("plataforma") ?: ""
                        TelaEscolhaGenero(navController, plataforma)
                    }
                    composable("celular_battle") { CelularBattle(navController) }
                    // Aqui vai a tela do Battle Royale no celular
                    composable("celular_aventura") {
                        // Aqui vai a tela MOBA no celular
                        AventuraCelular(navController)
                    }
                    composable("celular_com_amigos") {
                        // Aqui vai a tela de Jogos com Amigos no celular
                        JogarAmigos(navController)
                    }
                    composable("celular_aleatorio") {
                        // Aqui vai a tela Aleatória no celular
                        CelularAleatorioooo(navController)
                    }
                    composable("PC_battle") {
                        ComputadorBattle(navController)
                    }
                    composable("PC_aventura") {
                        AventuraPc(navController)
                    }
                    composable("PC_com_amigos") {
                        PcComAmigos(navController)
                    }
                    composable("PC_aleatorio") {
                        PcAleatorio(navController)
                    }
                    // Outras telas para outras plataformas
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenViewPreview() {
    ATividadeAppTheme {
        SplashScreen(onTimeout = {})
    }
}

@Preview(showBackground = true)
@Composable
fun TelaInicialPreviw() {
    ATividadeAppTheme {
        TelaInicial(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun TelasegundoPreviw() {
    ATividadeAppTheme {
        TelaEscolhaJogo(navController = rememberNavController())
    }
}

@Preview
@Composable
fun TelaescolhaComputadorPreview() {
    ATividadeAppTheme {

    }
}


@Composable
fun CelularPreview() {
    ATividadeAppTheme {
        CelularBattle(navController = rememberNavController())
    }
}

@Composable
@Preview
fun ConsolePreview() {
    ATividadeAppTheme {
        (rememberNavController())
    }
}

@Composable
@Preview
fun TelaEscolhageneroPrevie() {
    ATividadeAppTheme {
        TelaEscolhaGenero(navController = rememberNavController(), plataforma = "Celular")
    }
}



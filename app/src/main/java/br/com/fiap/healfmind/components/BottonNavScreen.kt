package br.com.fiap.healfmind.components

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.screens.HomeScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottonNavScreen() {
    Scaffold (
        bottomBar = { Footer() }
    ){
            paddingValues ->  HomeScreen(nome = "Wagner", navController = rememberNavController())
    }
}
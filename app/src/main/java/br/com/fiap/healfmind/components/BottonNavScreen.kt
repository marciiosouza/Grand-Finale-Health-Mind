package br.com.fiap.healfmind.components

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottonNavScreen() {
    Scaffold (
        bottomBar = { Footer() }
    ){
            //paddingValues ->  HomeScreen(nome = "Wagner", navController = rememberNavController())
    }
}
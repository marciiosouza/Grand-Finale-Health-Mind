package br.com.fiap.healfmind.components

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.screens.HomeScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavbar() {
    Scaffold (
        bottomBar = {
            Footer()
        }
    ){ paddingValues ->
        HomeScreen( navController = rememberNavController() , usuarios = Usuarios(1,"","","",""))
    }
}
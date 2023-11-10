package br.com.fiap.healfmind

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.healfmind.screens.HomeScreen

//@Composable
//fun BottomNavGraph(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
//        composable(route = BottomBarScreen.Home.route) {
//            var nome = it.arguments?.getString("nome")
//            HomeScreen(nome!!, navController )
//        }
//    }
//}
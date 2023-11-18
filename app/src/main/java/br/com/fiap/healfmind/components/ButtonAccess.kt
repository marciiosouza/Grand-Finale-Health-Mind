package br.com.fiap.healfmind.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController



@Composable
fun ButtonAccess(atualizarValor: (String) -> Unit , navController: NavController , textButton : String ) {

    Button(
        onClick = {
            atualizarValor
        },
        modifier = Modifier
            .width(300.dp)
            .height(56.dp)
            .background(color = Color(0xFF005FFF), shape = RoundedCornerShape(size = 5.dp)),

        colors = ButtonDefaults.buttonColors(Color(0xFF005FFF)),


        ){
        Text(text = textButton)
    }
}

@Preview
@Composable
fun ButtonAccesPreview() {
    ButtonAccess(atualizarValor = {} , rememberNavController() , "Entrar" )
}
package br.com.fiap.healfmind.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ButtonAccess(
    clique: () -> Unit,
    navController: NavController,
    textButton: String,
    modifier: Modifier,
    iconImage: Int,
    colorButtonColors: ButtonColors,
    textColor: Color,
    ) {
    Button(
        onClick = {
            clique()
        },
        modifier = modifier
            .width(300.dp)
            .height(56.dp),

        colors = colorButtonColors,
        shape = RoundedCornerShape(size = 5.dp),

    ) {

        Text(
            text = textButton,
            color = textColor
        )
    }
}


//@Preview
//@Composable
//fun ButtonAccesPreview() {
//    ButtonAccess(atualizarValor = {} , rememberNavController() , "Entrar", modifier = Modifier, iconImage = 1, )
//}
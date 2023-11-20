package br.com.fiap.healfmind.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.ui.theme.blue_gradient
import coil.compose.AsyncImage

@Composable
fun HeaderMenu(navController: NavController, usuarios: Usuarios) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .padding(start = 20.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text = "Menu",
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(id = R.drawable.icon_close),
            contentDescription = "Seta para esquerda",
            modifier = Modifier.size(32.dp)
        )
    }
}




@Preview()
@Composable
fun HeaderMenuPreview() {
    HeaderMenu(navController = rememberNavController() , Usuarios(1 , "Wagner" , "teste@" , "123" , ""))
}
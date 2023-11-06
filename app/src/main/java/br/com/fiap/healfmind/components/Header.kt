package br.com.fiap.healfmind.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R

@Composable
fun Header(navController:NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 15.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = {
                navController.navigate("Menu")
            }
        ) {
            Icon(painter = painterResource(id = R.drawable.menu_menu) ,contentDescription = "Menu",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),

                )}

        Text(
            text = "Home",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF005DF9),

                ),
        )
        IconButton(
            onClick = {
                navController.navigate("Perfil") }

        ) {
            Image(
                painter = painterResource(id = R.drawable.perfil) ,contentDescription = "Perfil",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(30.dp)),
                contentScale = ContentScale.FillBounds,
            )
        }
    }

}


@Preview()
@Composable
fun HeaderPreview() {
    Header(navController = rememberNavController())
}
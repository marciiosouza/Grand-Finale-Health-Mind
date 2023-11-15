package br.com.fiap.healfmind.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.ui.theme.purple_gradient

@Composable
fun Header(navController:NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .background(purple_gradient ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {
        IconButton(onClick = {
            // navController.navigate("Home/{nome}")
        }) {
            Image(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Seta para esquerda",
                modifier = Modifier.size(32.dp)
            )
        }
        Spacer(modifier = Modifier.width(48.dp))
        Text(
            text = "Meu Perfil",
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.width(64.dp))
        Image(
            painter = painterResource(id = R.drawable.perfil),
            contentDescription = "Imagem de uma jovem",
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview()
@Composable
fun HeaderPreview() {
    Header(navController = rememberNavController())
}
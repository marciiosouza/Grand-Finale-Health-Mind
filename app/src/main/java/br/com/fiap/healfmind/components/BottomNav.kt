package br.com.fiap.healfmind.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R

@Composable
fun BottomNav(navController: NavController) {
    NavigationBar(

    ) {
        NavigationBarItem(
            icon = {
                 Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                     modifier = Modifier
                         .padding(1.dp)
                         .width(22.145.dp)
                         .height(19.4847.dp),
                )
            },
            label = {
                Text(
                    text = "Home",
                        fontSize = 11.sp,
                        lineHeight = 13.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        color = Color(0xFF005DF9),
                        textAlign = TextAlign.Center,
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.healf),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(22.145.dp)
                        .height(19.4847.dp),
                )
            },
            label = {
                Text(
                    text = "Clínica",
                    fontSize = 11.sp,
                    lineHeight = 13.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = Color(0xFF999999),
                    textAlign = TextAlign.Center,
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.play),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(22.145.dp)
                        .height(19.4847.dp),
                )
            },
            label = {
                Text(
                    text = "Meditações",
                    fontSize = 11.sp,
                    lineHeight = 13.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = Color(0xFF999999),
                    textAlign = TextAlign.Center,
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.sleep),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(22.145.dp)
                        .height(19.4847.dp),
                )
            },
            label = {
                Text(
                    text = "Sono",
                    fontSize = 11.sp,
                    lineHeight = 13.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = Color(0xFF999999),
                    textAlign = TextAlign.Center,
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(22.145.dp)
                        .height(19.4847.dp),
                )
            },
            label = {
                Text(
                    text = "Perfil",
                    fontSize = 11.sp,
                    lineHeight = 13.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = Color(0xFF999999),
                    textAlign = TextAlign.Center,
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavScreenPreview() {
    BottomNav(navController = rememberNavController())
}

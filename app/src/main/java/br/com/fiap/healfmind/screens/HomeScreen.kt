package br.com.fiap.healfmind.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.components.ButtonAccess
import br.com.fiap.healfmind.components.Header
import br.com.fiap.healfmind.model.Usuarios

@Composable
fun HomeScreen(navController: NavController , usuarios: Usuarios) {
    Box {
        Column (
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Header(navController , usuarios )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Ola, ${usuarios.nome} ",
                style = TextStyle(
                    fontSize = 26.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )

            Text(
                text = "Conheça mais sobre o seu app! \nCuidados com seu bem-estar",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
            Spacer(Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.meditar),
                contentDescription = null,
                Modifier
                    .width(273.17511.dp)
                    .height(248.51343.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "A prática da meditação traz inúmeros benefícios para o bem-estar " +
                        "físico e mental. Ao cultivar a atenção plena, a meditação ajuda a " +
                        "reduzir o estresse e a ansiedade, promovendo um estado de relaxamento " +
                        "profundo.\n Além disso, ela fortalece a capacidade de concentração e " +
                        "melhora a qualidade do sono. ",
                Modifier.padding(start = 15.dp , end = 15.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center

                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            ButtonAccess(
                clique = {
                         navController.navigate("Meditacoes")
                },
                navController = navController,
                textButton = "Meditar",
                modifier = Modifier,
                iconImage = 0,
                colorButtonColors = ButtonDefaults.buttonColors(Color(0xFF005FFF)),
                textColor = Color.White,
                )

            Spacer(Modifier.height(16.dp))

        }

    }
}



@Preview
@Composable
fun HomeScreen2Preview() {
    HomeScreen(navController = rememberNavController(), Usuarios(1,"Wagner" , "" , "",""))
}
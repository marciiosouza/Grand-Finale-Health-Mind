package br.com.fiap.healfmind.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
import com.example.healf_mind.components.CardHome



@Composable
fun HomeScreen(  navController: NavController , usuarios: Usuarios ) {
    var pesquisa by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .background(
            Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (navController != null) {
                Header(navController , usuarios )
            }

            Column(modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {

                    Text(
                        text = "Olá," + "" + usuarios.nome + "  " + "Bom dia!",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.inter_bold)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000),
                        )
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Conheça mais sobre o seu app! \nCuidados com seu bem-estar",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 22.sp,
                            fontFamily = FontFamily(Font(R.font.inter_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    )

                    Spacer(modifier = Modifier.height(42.dp))

                    Image(
                        modifier = Modifier
                            .width(273.17511.dp)
                            .height(248.51343.dp),
                        painter = painterResource(id = R.drawable.woman_meditation),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(modifier = Modifier.height(42.dp))

                    Text(
                        text = "Lorem ipsum dolor sit amet consectetur. Lacinia venenatis nunc nulla enim nulla vel pulvinar metus. Lorem ipsum dolor sit amet consectetur.\n\nLorem ipsum dolor sit amet consectetur. Lacinia venenatis nunc nulla enim nulla vel pulvinar metus.\n\nLorem ipsum dolor sit amet consectetur. Lacinia venenatis nunc nulla enim nulla vel pulvinar metus. Lorem ipsum dolor sit amet consectetur.\n\nLorem ipsum dolor sit amet consectetur. Lacinia venenatis nunc nulla enim nulla vel pulvinar metus.\n",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 22.sp,
                            fontFamily = FontFamily(Font(R.font.inter_regular)),
                            color = Color(0xFF000000),
                        )
                    )


                    Spacer(modifier = Modifier.height(10.dp))

                    ButtonAccess(
                        atualizarValor = {},
                        navController = navController,
                        textButton = "Meditar",
                        modifier = Modifier,
                        iconImage = 1,
                        colorButtonColors = ButtonDefaults.buttonColors(Color(0xFF005FFF)),
                        textColor = Color.White
                    )
                }
            }
        }
    }
}



@Preview(showSystemUi =  true , showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController() , usuarios = Usuarios(1,"Wagner" , "teste" , "1234560" , "jpg"))
}


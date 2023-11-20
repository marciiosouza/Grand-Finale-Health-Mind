package br.com.fiap.healfmind.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import br.com.fiap.healfmind.model.Usuarios
import coil.compose.AsyncImage


@Composable
fun MenuScreen(usuarios: Usuarios , navController: NavController) {
    Box(modifier = Modifier.background(color = Color(0xFF005FFF))) {
        Column(
            Modifier.verticalScroll(rememberScrollState())
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 60.dp, end = 60.dp, top = 40.dp, bottom = 35.dp),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Menu",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.iconexit),
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.size(20.dp)
                )
            }
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = usuarios.fotoPerfil,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    modifier = Modifier
                        .size(97.dp)
                        .clip(shape = CircleShape)
                        .clickable {
                            navController.navigate("Perfil")
                        },
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Ola, ${usuarios.nome}",
                    Modifier.padding(top = 40.dp, bottom = 48.dp),
                    style = TextStyle(
                        fontSize = 26.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                    )

                )

                Text(
                    text = "Conheça mais sobre o seu app! de cuidados com seu bem-estar",
                    Modifier
                        .height(51.dp)
                        .width(203.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )

                )

                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    Modifier
                        //.fillMaxWidth()
                        .height(208.dp),
                    Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        Modifier.clickable {
                                           navController.navigate("Perfil")
                        },
                        verticalAlignment = Alignment.CenterVertically,

                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.icon_profile),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )

                        Text(
                            text = "Meu Perfil",
                            Modifier.padding(start = 10.dp),
                            style = TextStyle(
                                fontSize = 18.sp,
                                lineHeight = 25.2.sp,
                                fontFamily = FontFamily(Font(R.font.inter_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                    }
                    Row (
                        Modifier.clickable {
                            navController.navigate("Meditacoes")
                        },
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.icon_play),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )

                        Text(
                            text = "Meditações",
                            Modifier.padding(start = 10.dp),
                            style = TextStyle(
                                fontSize = 18.sp,
                                lineHeight = 25.2.sp,
                                fontFamily = FontFamily(Font(R.font.inter_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                    }
                    Row(

                        verticalAlignment = Alignment.CenterVertically
                    ) {
                       Icon(
                           painterResource(id = R.drawable.person_1),
                           contentDescription = null,
                           modifier = Modifier.size(20.dp),
                           tint = Color.White
                       )

                        Text(
                            text = "Comunidade",
                            Modifier.padding(start = 10.dp),
                            style = TextStyle(
                                fontSize = 18.sp,
                                lineHeight = 25.2.sp,
                                fontFamily = FontFamily(Font(R.font.inter_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painterResource(id = R.drawable.interrogation),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )

                        Text(
                            text = "Sobre nós",
                            Modifier.padding(start = 10.dp),
                            style = TextStyle(
                                fontSize = 18.sp,
                                lineHeight = 25.2.sp,
                                fontFamily = FontFamily(Font(R.font.inter_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                ButtonAccess(
                    clique = {
                             navController.navigate("Login")
                    },
                    navController = navController,
                    textButton = "Sair da conta",
                    modifier = Modifier,
                    iconImage = 1,
                    colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                    textColor = Color.Black
                )
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(Usuarios(1,"Wagner" , "","","") , navController = rememberNavController())
}


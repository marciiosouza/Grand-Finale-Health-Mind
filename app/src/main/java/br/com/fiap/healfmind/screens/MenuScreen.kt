package br.com.fiap.healfmind.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.components.ButtonAccess
import br.com.fiap.healfmind.components.ButtonProfile
import br.com.fiap.healfmind.components.HeaderMenu
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.ui.theme.blue_gradient
import br.com.fiap.healfmind.ui.theme.purple_gradient
import coil.compose.AsyncImage

@Composable
fun MenuScreen(navController: NavHostController, usuarios: Usuarios) {
    Box(modifier = Modifier
        .background(
            Brush.linearGradient(
                colors = listOf(
                    blue_gradient,
                    purple_gradient
                )
            )
        )
    )
    { if (navController != null) {
        HeaderMenu(navController , usuarios )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp, bottom = 25.dp)
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
                    text = "Olá," + "" + usuarios.nome + "  " + "Bom dia!",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color.White,
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Conheça mais sobre o seu \n app! de cuidados com seu \n bem-estar",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 22.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontWeight = FontWeight(400),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    )
                )


                Column (
                    Modifier.padding(top = 30.dp).height(220.dp).width(150.dp),
                    Arrangement.SpaceBetween,

                ){
                    Row (
                        Modifier.fillMaxWidth(),
                        Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.icon_person),
                            contentDescription = "image description",
                            Modifier
                                .height(18.dp)
                                .width(18.dp).clickable {
                                    navController.navigate("Perfil")
                                },
                            contentScale = ContentScale.FillBounds,

                        )
                        Text(
                            text = "Meu Perfil",
                            Modifier.padding(10.dp).clickable {
                                navController.navigate("Perfil")
                            },
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
                        Modifier.fillMaxWidth(),
                        Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.icon_play),
                            contentDescription = "image description",
                            Modifier
                                .height(18.dp)
                                .width(18.dp).clickable {
                                    navController.navigate("Meditacoes")
                                },
                            contentScale = ContentScale.FillBounds,


                        )
                        Text(
                            text = "Meditações",
                            Modifier.padding(10.dp).clickable {
                                navController.navigate("Meditacoes")
                            },
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
                        Modifier.fillMaxWidth(),
                        Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,

                    ){
                        Image(
                            painter = painterResource(id = R.drawable.person_1),
                            contentDescription = "image description",
                            Modifier
                                .height(15.dp)
                                .width(15.dp),
                            contentScale = ContentScale.FillBounds,
                        )

                        Text(
                            text = "Comunidade",
                            Modifier.padding(10.dp),
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
                        Modifier.fillMaxWidth(),
                        Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.interrogation),
                            contentDescription = "image description",
                            Modifier
                                .height(18.dp)
                                .width(18.dp),
                            contentScale = ContentScale.FillBounds,
                        )
                        Text(
                            text = "Sobre nós",
                            Modifier.padding(10.dp).clickable {
                                navController.navigate("Fundadores")
                            },
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

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Column {
                    }
                }
            }
        }
    }
    }
}
//ButtonProfile(
//onClique = {
//    navController.navigate("Perfil")
//},
//navController = rememberNavController() ,
//textButton = "Meu Perfil",
//modifier = Modifier ,
//iconImage = R.drawable.icon_person,
//colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
//textColor = Color.White
//)
//
//Spacer(modifier = Modifier.height(10.dp))
//
//ButtonProfile(
//onClique = {
//    navController.navigate("Meditacoes")
//},
//navController = rememberNavController() ,
//textButton = "Meditações",
//modifier = Modifier ,
//iconImage = R.drawable.icon_person,
//colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
//textColor = Color.White
//)
//
//Spacer(modifier = Modifier.height(10.dp))
//
//ButtonProfile(
//onClique = {
//
//},
//navController = rememberNavController() ,
//textButton = "Comunidade",
//modifier = Modifier ,
//iconImage = R.drawable.icon_person,
//colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
//textColor = Color.White
//)
//
//Spacer(modifier = Modifier.height(10.dp))
//
//ButtonProfile(
//onClique = {
//    navController.navigate("Fundadores")
//},
//navController = rememberNavController() ,
//textButton = "Sobre nós",
//modifier = Modifier ,
//iconImage = R.drawable.icon_person,
//colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
//textColor = Color.White
//)
//
//Spacer(modifier = Modifier.height(10.dp))
//
//ButtonAccess(
//clique = {
//    navController.navigate("Login")
//},
//navController = rememberNavController(),
//textButton = "Sair da conta",
//modifier = Modifier,
//iconImage = R.drawable.icon_exit,
//colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF)),
//textColor = Color.Black,
//)

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController() , usuarios = Usuarios(1,"","","",""))
}
package br.com.fiap.healfmind.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.media3.common.C.ColorTransfer
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.components.ButtonAccess
import br.com.fiap.healfmind.components.ButtonProfile
import br.com.fiap.healfmind.components.Header
import br.com.fiap.healfmind.components.HeaderMenu
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.ui.theme.blue_gradient
import br.com.fiap.healfmind.ui.theme.purple_gradient

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
                .padding(top = 40.dp),
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

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Column {
                        ButtonProfile(
                            atualizarValor = {},
                            navController = rememberNavController() ,
                            textButton = "Meu Perfil",
                            modifier = Modifier ,
                            iconImage = R.drawable.icon_person,
                            colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
                            textColor = Color.White
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        ButtonProfile(
                            atualizarValor = {},
                            navController = rememberNavController() ,
                            textButton = "Meditações",
                            modifier = Modifier ,
                            iconImage = R.drawable.icon_person,
                            colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
                            textColor = Color.White
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        ButtonProfile(
                            atualizarValor = {},
                            navController = rememberNavController() ,
                            textButton = "Comunidade",
                            modifier = Modifier ,
                            iconImage = R.drawable.icon_person,
                            colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
                            textColor = Color.White
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        ButtonProfile(
                            atualizarValor = {},
                            navController = rememberNavController() ,
                            textButton = "Sobre nós",
                            modifier = Modifier ,
                            iconImage = R.drawable.icon_person,
                            colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
                            textColor = Color.White
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        ButtonAccess(
                            clique = {},
                            navController = rememberNavController(),
                            textButton = "Sair da conta",
                            modifier = Modifier,
                            iconImage = R.drawable.icon_exit,
                            colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF)),
                            textColor = Color.Black,
                            atualizarValor = {},
                        )
                    }
                }
            }
        }
    }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController() , usuarios = Usuarios(1,"","","",""))
}
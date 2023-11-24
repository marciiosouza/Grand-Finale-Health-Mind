package br.com.fiap.healfmind.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
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
import br.com.fiap.healfmind.components.Header
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.ui.theme.purple_gradient
import coil.compose.AsyncImage

@Composable
fun FundadoresScreen(navController: NavController , usuarios: Usuarios) {

    val context = LocalContext.current

    fun AbreNavegador(context: Context, url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            // Tratar exceção, por exemplo, se não houver navegador instalado
            // ou se a URL não for válida
            Toast.makeText(context, "Erro ao abrir o navegador", Toast.LENGTH_SHORT).show()
        }
    }
    Box( ){
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Header(navController = navController, usuarios = usuarios)

            Card(
                modifier = Modifier
                    .width(320.dp)
                    .height(150.dp)
                    .padding(top = 25.dp),

                colors = CardDefaults.cardColors(purple_gradient)
            ) {
                Text(
                    text = "Projeto desenvolvido para Fintech",
                    Modifier.padding(top = 35.dp),
                    style = TextStyle(
                        fontSize = 21.sp,
                        lineHeight = 23.57.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center
                    )
                )
            }

            Column(
                Modifier.padding(top = 36.dp , bottom = 40.dp)
            ) {

                Text(
                    text = "Marcio e Wagner combinaram suas habilidades em programação e design para criar um " +
                            "aplicativo inovador voltado para a saúde mental. Sua colaboração resultou em " +
                            "uma ferramenta que oferece suporte emocional, promove o bem-estar e torna a g" +
                            "estão da saúde mental mais acessível a todos.",
                    Modifier.padding(start = 10.dp , end = 10.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 23.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )
            }

            Column {
                Row (
                    Modifier.width(200.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,

                    ){
                    Image(
                        painterResource(id = R.drawable.marcio_perfil),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = CircleShape)
                            .clickable {

                            },
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier.padding(top = 30.dp)
                    ) {
                        Text(
                            text = "Marcio Souza",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.inter_bold)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            text = "Diretor",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            text = "Desenvolvedor FullStack\nUI Design",
                            style = TextStyle(
                                fontSize = 9.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                        Row(
                            Modifier.width(35.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.github_icon),
                                    contentDescription = "GitHub",
                                    Modifier
                                        .size(16.dp)
                                        .clickable {
                                            val url = "https://github.com/marciiosouza"
                                            AbreNavegador(context, url)

                                        },

                                    )

                            }

                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.linkedin_icon),
                                    contentDescription = "Linkedin",
                                    Modifier
                                        .size(16.dp)
                                        .clickable {
                                            val url = "https://www.linkedin.com/in/marciiosouza/"
                                            AbreNavegador(context, url)

                                        }
                                )

                            }
                        }

                    }

                }
                Row (
                    Modifier.width(215.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,

                    ){
                    Image(
                        painterResource(id = R.drawable.wagner_perfil),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = CircleShape)
                            .clickable {

                            },
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier.padding(top = 30.dp)
                    ) {
                        Text(
                            text = "Wagner Morais",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.inter_bold)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            text = "CEO",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            text = "Desenvolvedor Back-End",
                            style = TextStyle(
                                fontSize = 9.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                        Row (
                            Modifier.width(35.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.github_icon),
                                    contentDescription = "GitHub",
                                    Modifier
                                        .size(16.dp)
                                        .clickable {
                                            val url = "https://github.com/marciiosouza"
                                            AbreNavegador(context, url)

                                        }
                                )

                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.linkedin_icon),
                                    contentDescription = "Linkedin",
                                    Modifier
                                        .size(16.dp)
                                        .clickable {
                                            val url =
                                                "https://www.linkedin.com/in/wagner-morais-araujo-646375118/"
                                            AbreNavegador(context, url)

                                        }


                                )

                            }
                        }

                    }

                }

            }
            Spacer(Modifier.height(30.dp))



        }

    }
}



@Preview(showSystemUi =  true)
@Composable
fun FundadoresScreenPreview() {

    FundadoresScreen(navController = rememberNavController() , usuarios = Usuarios(1,"","","",""))
}
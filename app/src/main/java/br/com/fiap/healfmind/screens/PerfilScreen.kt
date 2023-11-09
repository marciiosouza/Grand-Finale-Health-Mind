package br.com.fiap.healfmind.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
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
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.ui.theme.blue_gradient
import br.com.fiap.healfmind.ui.theme.purple_gradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//fun PerfilScreen() {
fun PerfilScreen(navController: NavController?) {

    var nome = "Marcio"
    Box(modifier = Modifier
        .background(
            Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(colorResource(id = R.color.azul)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                IconButton(onClick = {
                   // navController.navigate("Home/{nome}")
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Seta para esquerda",
                        modifier = Modifier.size(15.dp)
                    )
                }
                Spacer(modifier = Modifier.width(48.dp))
                Text(
                    text = "Meu Perfil",
                    color = colorResource(id = R.color.white),
                    fontFamily = FontFamily(Font(R.font.inter_bold))
                )
                Spacer(modifier = Modifier.width(64.dp))
                Image(
                    painter = painterResource(id = R.drawable.jovem_profile),
                    contentDescription = "Imagem de uma jovem",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            // Formulário

            Column(modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )

            {
                Text(
                    text = "Dados Pessoais",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )

                Spacer(modifier = Modifier.height(26.dp))

                TextField(modifier = Modifier
                    .width(303.dp)
                    .height(50.dp)
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    )
                    .background(
                        color = Color(0xFFFAFAFA),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .border(
                        width = 1.dp, color = Color(0xFFC3C3C3),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),

                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(
                            text = "Nome Completo:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0x4A000000),
                            )
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                TextField(modifier = Modifier
                    .width(303.dp)
                    .height(50.dp)
                    .background(
                        color = Color(0xFFFAFAFA),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .border(
                        width = 1.dp, color = Color(0xFFC3C3C3),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),

                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(
                            text = "CPF:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0x4A000000),
                            )
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Dados de contato",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )

                Spacer(modifier = Modifier.height(26.dp))

                TextField(modifier = Modifier
                    .width(303.dp)
                    .height(50.dp)
                    .background(
                        color = Color(0xFFFAFAFA),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .border(
                        width = 1.dp, color = Color(0xFFC3C3C3),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),

                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(
                            text = "Celular:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0x4A000000),
                            )
                        )
                    },
                    trailingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = "Icone editar",
                            modifier = Modifier
                                .width(14.dp)
                                .height(14.dp)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                TextField(modifier = Modifier
                    .width(303.dp)
                    .height(50.dp)
                    .background(
                        color = Color(0xFFFAFAFA),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .border(
                        width = 1.dp, color = Color(0xFFC3C3C3),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),

                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(
                            text = "E-mail:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0x4A000000),
                            )
                        )
                    },
                    trailingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = "Icone editar",
                            modifier = Modifier
                                .width(14.dp)
                                .height(14.dp)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                TextField(modifier = Modifier
                    .width(303.dp)
                    .height(50.dp)
                    .background(
                        color = Color(0xFFFAFAFA),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .border(
                        width = 1.dp, color = Color(0xFFC3C3C3),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),

                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(
                            text = "Endereço:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0x4A000000),
                            )
                        )
                    },
                    trailingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = "Icone editar",
                            modifier = Modifier
                                .width(14.dp)
                                .height(14.dp)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Segurança",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            text = "Alterar senha do app",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                color = Color(0xFFAFAFAF),
                            )
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Image(
                            painter = painterResource(id = R.drawable.arrow_direita),
                            contentDescription = "Seta para esquerda",
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Contratos",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))


                Text(text = "Contrato de adesão",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        color = Color(0xFF005DF9),
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = "Termos e condições de uso",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        color = Color(0xFF005DF9),
                    )
                )

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    onClick = {
                        navController?.navigate("Login")
                    },
                    modifier = Modifier
                        .width(303.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(size = 10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.azul))

                ) {
                    Text(text = "Sair da conta")

                    Spacer(modifier = Modifier.width(8.dp))

                    Image(
                        painter = painterResource(id = R.drawable.sair),
                        contentDescription = "Seta para esquerda",
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PerfilScreenPreview() {
    PerfilScreen(navController = null)
}




package br.com.fiap.healfmind.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.healfmind.R
@Composable
//fun PerfilScreen() {
fun PerfilScreen(navController: NavController) {

    var nome = "Marcio"
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            // ---- header ---------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(colorResource(id = R.color.azul)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center // Centraliza horizontalmente
            ) {

                IconButton(onClick = {

                   navController.navigate("Home/{nome}")
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Seta para esquerda",
                        modifier = Modifier.size(15.dp)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "voltar",
                    color = colorResource(id = R.color.white)

                )

                Spacer(modifier = Modifier.width(55.dp))
                Text(
                    text = "Meu Perfil",
                    color = colorResource(id = R.color.white),
                    fontFamily = FontFamily(Font(R.font.inter_bold))
                )
                Spacer(modifier = Modifier.width(55.dp))
                Image(
                    painter = painterResource(id = R.drawable.jovem_profile),
                    contentDescription = "Imagem de uma jovem",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
            }



            // --- formulário

            Column(modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()))


            {



                Text(
                    text = "Dados Pessoais",
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    color = colorResource(id = R.color.preto),


                )

                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    value = "" ,
                    onValueChange = {},
                    placeholder = {
                        Text(text = "Nome Completo:",
                            color = colorResource(id = R.color.cinza),
                            fontFamily = FontFamily(Font(R.font.inter_regular))
                        )
                    })

                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    value = "" ,
                    onValueChange = {},
                    placeholder = {
                        Text(text = "CPF:",
                            color = colorResource(id = R.color.cinza)
                        )
                    }


                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Dados de contato",
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    color = colorResource(id = R.color.preto)

                )
                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    value = "" ,
                    onValueChange = {},
                    placeholder = {
                        Text(text = " Celular: ",
                            color = colorResource(id = R.color.cinza)
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
                    })
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    value = "" ,
                    onValueChange = {},
                    placeholder = {
                        Text(text = "E-mail: ",
                            color = colorResource(id = R.color.cinza)
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
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    value = "" ,
                    onValueChange = {},
                    placeholder = {
                        Text(text = "Endereço: ",
                            color = colorResource(id = R.color.cinza)
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
                    }
                )

                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Segurança",
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    color = colorResource(id = R.color.preto)

                )

                Spacer(modifier = Modifier.height(12.dp))



                Row {
                    Text(
                        text = "Alterar a senha do app",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        color = colorResource(id = R.color.cinza),

                        )

                    Spacer(modifier = Modifier.width(25.dp))
                    Image(
                        painter = painterResource(id = R.drawable.arrow_direita),
                        contentDescription = "Seta para direita",
                        Modifier.size(15.dp)
                    )
                }


                Column {


                    Spacer(modifier = Modifier.height(12.dp),)
                    Text(
                        text = "Contratos",
                        fontSize = 17.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        color = colorResource(id = R.color.preto),


                        )

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Contrato de adesão",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        color = colorResource(id = R.color.azul),
                        )

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = "Termos e condições de uso",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        color = colorResource(id = R.color.azul),
                    )

                    Spacer(modifier = Modifier.height(25.dp))
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(
                                width = 300.dp,
                                height = 50.dp
                            )
                            .padding(bottom = 10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005DF9)),

                        
                    )
                    {

                        Text(text = "sair da conta")
                        Spacer(modifier = Modifier.height(25.dp))

                    }
                }
            }
        }
    }
}

//@Preview(showSystemUi =  true , showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    PerfilScreen()
//}

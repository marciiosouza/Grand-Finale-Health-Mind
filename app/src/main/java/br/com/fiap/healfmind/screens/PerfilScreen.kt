package br.com.fiap.healfmind.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.components.ButtonAccess
import br.com.fiap.healfmind.components.Header
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.viewModel.PerfilScreenViewModel
import com.example.healf_mind.components.CaixaDeEntrada


@Composable
fun PerfilScreen(navController: NavController? , usuarios: Usuarios , perfilScreenViewModel: PerfilScreenViewModel) {

    val nome by perfilScreenViewModel.nome.observeAsState(initial = usuarios.nome)
    val cpf by perfilScreenViewModel.cpf.observeAsState(initial = "")
    val celular by perfilScreenViewModel.celular.observeAsState(initial = "")
    val email by perfilScreenViewModel.email.observeAsState(initial = usuarios.email)
    val endereco by perfilScreenViewModel.endereco.observeAsState(initial = "")

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
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )

                Spacer(modifier = Modifier.height(26.dp))

                Box(
                    modifier = Modifier
                        .border(1.dp, color = Color(0xFFB5B5B5), shape = RoundedCornerShape(size = 5.dp))
                ) {
                    CaixaDeEntrada(
                        label = "",
                        placeholder = "Nome",
                        value = nome,
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier,
                        atualizarValor = {
                                         perfilScreenViewModel.onNomeChanged(it)
                        },
                        error = true,
                        iconImage = R.drawable.icon_person,
                        colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .border(1.dp, color = Color(0xFFB5B5B5), shape = RoundedCornerShape(size = 5.dp))
                ) {
                    CaixaDeEntrada(
                        label = "",
                        placeholder = "CPF",
                        value = cpf,
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier,
                        atualizarValor = {
                            perfilScreenViewModel.onCpfChanged(it)
                        },
                        error = true,
                        iconImage = R.drawable.icon_person,
                        colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                    )
                }

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Dados decontato",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )

                Spacer(modifier = Modifier.height(26.dp))

                Box(
                    modifier = Modifier
                        .border(1.dp, color = Color(0xFFB5B5B5), shape = RoundedCornerShape(size = 5.dp))
                ) {
                    CaixaDeEntrada(
                        label = "",
                        placeholder = "Celular",
                        value = celular,
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier,
                        atualizarValor = {
                            perfilScreenViewModel.onCelularChanged(it)
                        },
                        error = true,
                        iconImage = R.drawable.icon_edit,
                        colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .border(1.dp, color = Color(0xFFB5B5B5), shape = RoundedCornerShape(size = 5.dp))
                ) {
                    CaixaDeEntrada(
                        label = "",
                        placeholder = "E-mail",
                        value = email,
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier,
                        atualizarValor = {
                            perfilScreenViewModel.onEmailChanged(it)
                        },
                        error = true,
                        iconImage = R.drawable.icon_edit,
                        colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .border(1.dp, color = Color(0xFFB5B5B5), shape = RoundedCornerShape(size = 5.dp))
                ) {
                    CaixaDeEntrada(
                        label = "",
                        placeholder = "Endereco",
                        value = endereco,
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier,
                        atualizarValor = {
                            perfilScreenViewModel.onEnderecoChanged(it)
                        },
                        error = true,
                        iconImage = R.drawable.icon_edit,
                        colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                    )
                }

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Segurança",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )

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

                ButtonAccess(
                    clique = {},
                    navController = rememberNavController(),
                    textButton = "Sair da conta",
                    modifier = Modifier,
                    iconImage = R.drawable.icon_exit,
                    colorButtonColors = ButtonDefaults.buttonColors(Color(0xFF005FFF)),
                    textColor = Color.White
                ) {}

                ButtonAccess(
                    clique = {},
                    navController = rememberNavController(),
                    textButton = "Excluir conta",
                    modifier = Modifier,
                    iconImage = R.drawable.icon_delete,
                    colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
                    textColor = Color.Red
                ) {}
            }
        }
    }
}

//@Preview
//@Composable
//fun PerfilScreenPreview() {
//    PerfilScreen(navController = rememberNavController() , usuarios = Usuarios(1,"","","",""))
//}




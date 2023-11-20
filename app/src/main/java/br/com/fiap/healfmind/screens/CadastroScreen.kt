package br.com.fiap.healfmind.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.components.ButtonAccess
import br.com.fiap.healfmind.database.repository.UsuarioRepository
import br.com.fiap.healfmind.ui.theme.blue_gradient
import br.com.fiap.healfmind.ui.theme.purple_gradient
import br.com.fiap.healfmind.viewModel.CadastroScreenViewModel
import com.example.healf_mind.components.CaixaDeEntrada

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(navController: NavController, cadastroScreenViewModel: CadastroScreenViewModel) {

    val nome by cadastroScreenViewModel.nome.observeAsState(initial = "")
    val email by cadastroScreenViewModel.email.observeAsState(initial = "")
    val senha by cadastroScreenViewModel.senha.observeAsState(initial = "")
    var fotoPerfil by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)

    Box(modifier = Modifier
        .background(
            Brush.linearGradient(
                colors = listOf(
                    purple_gradient,
                    blue_gradient

                )
            )
        )
    )

    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                CaixaDeEntrada(
                    label = "",
                    placeholder = "Nome",
                    value = senha,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier,
                    atualizarValor = {},
                    error = true,
                    iconImage = R.drawable.icon_person,
                    colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                )


                Spacer(modifier = Modifier.height(10.dp))

                CaixaDeEntrada(
                    label = "",
                    placeholder = "E-mail",
                    value = senha,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier,
                    atualizarValor = {},
                    error = true,
                    iconImage = R.drawable.icon_email,
                    colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                )

                Spacer(modifier = Modifier.height(10.dp))

                CaixaDeEntrada(
                    label = "",
                    placeholder = "Senha",
                    value = senha,
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier,
                    atualizarValor = {},
                    error = true,
                    iconImage = R.drawable.icon_lock,
                    colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            ButtonAccess(
                clique = {},
                navController = navController,
                textButton = "Fazer Cadastro",
                modifier = Modifier,
                iconImage = 1,
                colorButtonColors = ButtonDefaults.buttonColors(Color(0xFF005FFF)),
                textColor = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            ButtonAccess(
                clique = {},
                navController = navController,
                textButton = "Entrar com o Google",
                modifier = Modifier,
                iconImage = R.drawable.icon_google,
                colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF)),
                textColor = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            ButtonAccess(
                clique = {},
                navController = navController,
                textButton = "Fazer login",
                modifier = Modifier
                    .border(width = 1.dp, color = Color(0xFFE6EFFF),
                        shape = RoundedCornerShape(size = 5.dp)
                    ),
                iconImage = R.drawable.icon_google,
                colorButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
                textColor = Color.White
            )
        }

        /*{

            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .width(140.dp)
                    .height(112.41309.dp)
            )

            Spacer(modifier = Modifier.height(60.dp))
            
            Text(
                text = "Realizar Cadastro",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    color = Color(0xFFFFFFFF),
                )
            )

            Spacer(modifier = Modifier.height(38.dp))

            OutlinedTextField(modifier = Modifier
                .width(303.dp)
                .height(50.dp)
                .background(
                    color = Color(0xFFFAFAFA),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .border(0.dp, Color.Transparent),

                value = nome,
                onValueChange = {
                                cadastroScreenViewModel.onNameChanged(it)
                },

                placeholder = {
                    Text(
                        text = "Nome",
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

            Spacer(modifier = Modifier.height(17.dp))

            OutlinedTextField(modifier = Modifier
                .width(303.dp)
                .height(50.dp)
                .background(
                    color = Color(0xFFFAFAFA),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .border(0.dp, Color.Transparent),

                value = email,
                onValueChange = {
                                cadastroScreenViewModel.onEmailChanged(it)
                },

                placeholder = {
                    Text(
                        text = "E-mail",
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

            Spacer(modifier = Modifier.height(17.dp))

            OutlinedTextField(modifier = Modifier
                .width(303.dp)
                .height(50.dp)
                .background(
                    color = Color(0xFFFAFAFA),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .border(0.dp, Color.Transparent),

                value = senha,
                onValueChange = {
                                cadastroScreenViewModel.onSenhaChanged(it)
                },

                placeholder = {
                    Text(
                        text = "Senha",
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

            Spacer(modifier = Modifier.height(17.dp))

            Button(
                onClick = {
                    val usuario = Usuarios(0, nome = nome , senha =  senha , email = email , fotoPerfil = fotoPerfil)
                    val call = RetrofitFactory().getUsuarioService().inserirUsuario(usuario)

                    call.enqueue(object : Callback<Usuarios>{
                        override fun onResponse(
                            call: Call<Usuarios>,
                            response: Response<Usuarios>
                        ) {
                            navController.navigate("Login")
                        }

                        override fun onFailure(call: Call<Usuarios>, t: Throwable) {
                            Log.i("C$#", "onFailure: ${t.message}")
                        }

                    })
                },
                modifier = Modifier
                    .width(303.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.azul)
                )

            ) {
                Text(text = "Cadastrar")
            }

            Spacer(modifier = Modifier.height(17.dp))

            Button(
                onClick = {

                },
                modifier = Modifier
                    .width(303.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.white)
                )
            ) {
                Text(
                    text = "Entrar com o Google",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000)
                    )
                )

                Spacer(modifier = Modifier.width(17.dp))

                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Seta para esquerda",
                    modifier = Modifier.size(20.dp)
                )
            }
        }*/
    }
}




@Preview
@Composable
fun LoginScreenPreview() {
    val cadastroScreenViewModel = CadastroScreenViewModel()
    CadastroScreen(cadastroScreenViewModel = cadastroScreenViewModel, navController = rememberNavController())
}
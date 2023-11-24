package br.com.fiap.healfmind.screens

import android.util.Log
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
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.service.RetrofitFactory
import br.com.fiap.healfmind.ui.theme.blue_gradient
import br.com.fiap.healfmind.ui.theme.purple_gradient
import br.com.fiap.healfmind.viewModel.CadastroScreenViewModel
import com.example.healf_mind.components.CaixaDeEntrada
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CadastroScreen(navController: NavController, cadastroScreenViewModel: CadastroScreenViewModel) {

    val nome by cadastroScreenViewModel.nome.observeAsState(initial = "")
    val email by cadastroScreenViewModel.email.observeAsState(initial = "")
    val senha by cadastroScreenViewModel.senha.observeAsState(initial = "")
    var fotoPerfil by remember {
        mutableStateOf("fotopadrao.jpg")
    }
    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)

    fun cadastroUsuario(){
        val usuario = Usuarios(0, nome = nome , senha =  senha , email = email , fotoPerfil = fotoPerfil)
        val call = RetrofitFactory().getUsuarioService().inserirUsuario(usuario)

        call.enqueue(object : Callback<Usuarios> {
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
    }

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
                    value = nome,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier,
                    atualizarValor = {
                        cadastroScreenViewModel.onNameChanged(it)
                    },
                    error = true,
                    iconImage = R.drawable.icon_person,
                    colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                )


                Spacer(modifier = Modifier.height(10.dp))

                CaixaDeEntrada(
                    label = "",
                    placeholder = "E-mail",
                    value = email,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier,
                    atualizarValor = {
                        cadastroScreenViewModel.onEmailChanged(it)
                    },
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
                    atualizarValor = {
                        cadastroScreenViewModel.onSenhaChanged(it)
                    },
                    error = true,
                    iconImage = R.drawable.icon_profile,
                    colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            ButtonAccess(
                clique = {
                    cadastroUsuario()
                },
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
                clique = {
                    navController.navigate("Login")
                },
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
    }
}




@Preview
@Composable
fun LoginScreenPreview() {
    val cadastroScreenViewModel = CadastroScreenViewModel()
    CadastroScreen(cadastroScreenViewModel = cadastroScreenViewModel, navController = rememberNavController())
}
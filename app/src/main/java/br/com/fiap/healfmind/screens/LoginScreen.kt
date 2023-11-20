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
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.components.ButtonAccess
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.service.RetrofitFactory
import br.com.fiap.healfmind.ui.theme.blue_gradient
import br.com.fiap.healfmind.ui.theme.purple_gradient
import com.example.healf_mind.components.CaixaDeEntrada
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun LoginScreen( loginScreenViewModel: LoginScreenViewModel ,navController: NavController , usuarios: Usuarios, onLoginSuccess: (Usuarios) -> Unit) {

    val texto by loginScreenViewModel.texto.observeAsState(initial = "")
    val senha by loginScreenViewModel.password.observeAsState(initial = "")
    var email by remember { mutableStateOf("") }
    val tamanhoMax  = 10
    var fotoPerfil by remember {
        mutableStateOf("")
    }

    fun login(){

        val usuario = Usuarios(0,"", texto, senha , fotoPerfil)
        Log.i("Aqui", "onFailure:= ")
        val call = RetrofitFactory().getUsuarioService().getUsuarioByEmailSenha(usuario)
        call.enqueue(object : Callback<Usuarios> {
            override fun onResponse(
                call: Call<Usuarios>,
                response: Response<Usuarios>
            ) {
                val respostaApi = response.body()
                if (respostaApi != null) {
                    Log.i("Deu certo", "${respostaApi} ")
                    onLoginSuccess(respostaApi)
                    navController.navigate("Home")
                }
            }
            override fun onFailure(call: Call<Usuarios>, t: Throwable) {
                Log.i("DeuErrado", "onFailure:${t.message} ")
            }
        })
    }

    var isEmailValid by remember { mutableStateOf(true) }

    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return email.matches(emailRegex)
    }




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


    {
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
                CaixaDeEntrada(
                    label = "",
                    placeholder = "E-mail",
                    value = texto,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier,
                    atualizarValor = {
                        loginScreenViewModel.onTextoChanged(it)
                        isEmailValid = isEmailValid(texto)
                    },
                    error = true,
                    iconImage = R.drawable.icon_email,
                    colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                )
                if (!isEmailValid) {
                    Text(
                        text = "Por favor, insira um e-mail válido.",
                        Modifier
                            .padding(top = 2.dp, start = 40.dp)
                            .fillMaxWidth(),
                        color = Color.Red,
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))

                CaixaDeEntrada(
                    label = "",
                    placeholder = "Senha",
                    value = senha,
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier,
                    atualizarValor = {
                        loginScreenViewModel.onPasswordChanged(it)
                    },
                    error = true,
                    iconImage = R.drawable.icon_profile,
                    colorButtonColors = ButtonDefaults.buttonColors(Color(0xFFE6EFFF))
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            ButtonAccess(
                clique = {
                    login()
                },
                navController = navController,
                textButton = "Realizar login",
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
                         navController.navigate("Cadastro")
                },
                navController = navController,
                textButton = "Criar conta",
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
    val loginScreenViewModel = LoginScreenViewModel()
    LoginScreen(loginScreenViewModel = loginScreenViewModel, navController = rememberNavController() , usuarios = Usuarios(1 ,"Wagner Morais" , "wag@gmail", "123","teste.jpg") ,onLoginSuccess = {} )
}
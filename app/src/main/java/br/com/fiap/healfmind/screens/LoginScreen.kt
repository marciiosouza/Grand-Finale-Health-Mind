import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.screens.HomeScreen
import br.com.fiap.healfmind.service.RetrofitFactory
import br.com.fiap.healfmind.ui.theme.ColorWhite
import br.com.fiap.healfmind.ui.theme.Inter
import br.com.fiap.healfmind.ui.theme.blue_gradient
import br.com.fiap.healfmind.ui.theme.purple_gradient
import com.example.healf_mind.components.CaixaDeEntrada
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen( loginScreenViewModel: LoginScreenViewModel ,navController: NavController) {

    val texto by loginScreenViewModel.texto.observeAsState(initial = "")
    val senha by loginScreenViewModel.password.observeAsState(initial = "")
    val tamanhoMax  = 10
    var erroEmail by remember {
        mutableStateOf(false)
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
        ){
            Text(
                text = "Faça seu Login",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )
            )

            Spacer(modifier = Modifier
                .height(16.dp)
            )



            Box(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.white),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .width(303.dp)
                    .height(50.dp)
            ) /*{
                TextField(
                    value = "",
                    onValueChange = { },
                    label = {
                        Text(
                            text = "E-mail",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular)),
                                fontWeight = FontWeight(400)
                            )
                        )
                    }
                )
            }*/



            Spacer(modifier = Modifier
                .height(16.dp))

            TextField( modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x1A000000),
                    ambientColor = Color(0x1A000000)
                )
                .width(303.dp)
                .height(50.dp)
                .background(
                    color = Color(0xFFFAFAFA),
                    shape = RoundedCornerShape(size = 10.dp)
                ),

                value = "",
                onValueChange = {},
                label = {
                    Text(
                        text = "Senha",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.inter_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0x4A000000),
                        )
                    )
                }
            )

            Spacer(modifier = Modifier
                .height(16.dp))

            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(
                        blue_gradient
                    )
                    .width(303.dp)
                    .height(50.dp),

                ) {
                Text(text = "Entrar")
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Entrar com o Google")
            }

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Esqueci minha senha")
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
}

@Preview
@Composable


fun LoginScreenPreview() {
    val loginScreenViewModel = LoginScreenViewModel()
    LoginScreen(loginScreenViewModel = loginScreenViewModel, navController = rememberNavController())
}
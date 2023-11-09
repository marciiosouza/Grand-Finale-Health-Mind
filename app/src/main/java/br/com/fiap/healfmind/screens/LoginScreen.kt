import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
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

@OptIn(ExperimentalMaterial3Api::class)
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
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .width(140.dp)
                    .height(112.41309.dp)
            )

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "Faça seu Login",
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

                value = "",
                onValueChange = { },

               placeholder = {
                   Text(
                       text = "Digite o seu e-mail",
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

                value = "",
                onValueChange = { },

                placeholder = {
                    Text(
                        text = "Digite a sua senha",
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
                onClick = { navController.navigate("Home/Marcio") },
                modifier = Modifier
                    .width(303.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.azul))

            ) {
                Text(text = "Entrar")
            }

            Spacer(modifier = Modifier.height(17.dp))

            Button(
                onClick = { /*TODO*/ },
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

                    Spacer(modifier = Modifier.width(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Seta para esquerda",
                        modifier = Modifier.size(20.dp),
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Criar conta com e-mail",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.inter_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                        )
                    )
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
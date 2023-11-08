package br.com.fiap.healfmind.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(navController: NavController, cadastroScreenViewModel: CadastroScreenViewModel) {

    val nome by cadastroScreenViewModel.nome.observeAsState(initial = "")
    val email by cadastroScreenViewModel.email.observeAsState(initial = "")
    val senha by cadastroScreenViewModel.senha.observeAsState(initial = "")
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
        ){
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

                value = "",
                onValueChange = { },

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

                value = "",
                onValueChange = { },

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

                value = "",
                onValueChange = { },

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
                onClick = { /*TODO*/ },
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

                Spacer(modifier = Modifier.width(17.dp))

                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Seta para esquerda",
                    modifier = Modifier.size(15.dp)
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
    val cadastroScreenViewModel = CadastroScreenViewModel()
    CadastroScreen(cadastroScreenViewModel = cadastroScreenViewModel, navController = rememberNavController())
}
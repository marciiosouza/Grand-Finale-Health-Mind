import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.healf_mind.components.CaixaDeEntrada
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun LoginScreen( loginScreenViewModel: LoginScreenViewModel ,navController: NavController) {
//fun LoginScreen( ) {
    // Var de estado para capturar texto dos inputs
    //var texto by remember { mutableStateOf("") }
    // utilizamos o by para não precisar digitar var.value para obter o valor da var
    val texto by loginScreenViewModel.texto.observeAsState(initial = "")


    val senha by loginScreenViewModel.password.observeAsState(initial = "")

    val tamanhoMax  = 10
    var erroEmail by remember {
        mutableStateOf(false)
    }


    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Image(
            painterResource(id = R.drawable.tela_login) ,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(
        modifier = Modifier
            //.size(width = 30.dp, height = 40.dp)
            //.background(Color(0xFF3D5FE2))
            .padding(top = 50.dp)
            .fillMaxHeight()
            .fillMaxWidth(),


        horizontalAlignment = Alignment.CenterHorizontally,

        ){
//        Image(
//            painter = painterResource(id = R.drawable.recepcao_health) , contentDescription = null,
//            contentScale = ContentScale.FillHeight,
//
//            )

        Card( //.padding(30.dp),
            modifier = Modifier
                .height(400.dp)
                .width(360.dp)
                .fillMaxWidth()
                .padding(20.dp),
            colors = CardDefaults.cardColors(Color(0xFFFAFAFA)),
            shape = RoundedCornerShape(35.dp),
            elevation = CardDefaults.cardElevation(4.dp)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 40.dp),


                horizontalAlignment = Alignment.CenterHorizontally

//
            ){
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF005DF9)
                ))
                CaixaDeEntrada(
                    label = "Insira seu e-mail",
                    placeholder = "Digite seu e-mail aqui",
                    value = texto,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x1A000000),
                            ambientColor = Color(0x1A000000)
                        )
                        .width(270.dp)
                        //.height(50.dp)
                    //.background(
                    // color = Color(0xFFFAFAFA),
                    //shape = RoundedCornerShape(size = 30.dp)
                    //)
                    //.padding(top = 20.dp,bottom = 50.dp)
                    ,
                    atualizarValor = {
                        loginScreenViewModel.onTextoChanged(it)
                    },
                    erroEmail

                )
                if(erroEmail){
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        textAlign = TextAlign.End,
                        text = "O e-mail é obrigatório!",
                        fontSize = 14.sp,
                        color = Color.Red
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))

                CaixaDeEntrada(
                    label = "Insira sua senha",
                    placeholder = "Insira sua senha",
                    value = senha,
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x1A000000),
                            ambientColor = Color(0x1A000000)
                        )
                        .width(270.dp),
                        //.height(50.dp),
                    //.background(
                    // color = Color(0xFFFAFAFA),
                    //shape = RoundedCornerShape(size = 30.dp)
                    // ),
                    atualizarValor = {
                        if(it.length <= tamanhoMax)
                            loginScreenViewModel.onPasswordChanged(it)
                    },
                    false
                )

                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        var call = RetrofitFactory().getUsuarioService().getUsuarioByEmailSenha(
                            email = texto,
                            senha = senha
                        )

                        call.enqueue(object  : Callback<Usuarios>{
                            override fun onResponse(
                                call: Call<Usuarios>,
                                response: Response<Usuarios>
                            ) {

                            }

                            override fun onFailure(call: Call<Usuarios>, t: Throwable) {

                            }

                        })

                        if(texto.isEmpty()){
                            erroEmail = true
                        } else{
                            erroEmail = false
                            navController.navigate("Home/Wagner")
                        }
                    },
                    modifier = Modifier
                        .size(width = 230.dp, height = 50.dp)
                        .padding(bottom = 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005DF9))

                ) {
                    Text(
                        text = "Entrar",

                        )

                }


                TextButton(
                    onClick = {
                        navController.navigate("Cadastro")
                    }
                ) {
                    Text(
                        text = "Criar conta com e-mail",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.inter_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF005DF9),
                        )
                    )
                }



                    //modifier = Modifier.padding(top = 30.dp)


            }
        }
    }
}




package br.com.fiap.healfmind.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.database.repository.UsuarioRepository
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.service.RetrofitFactory
import br.com.fiap.healfmind.viewModel.CadastroScreenViewModel
import com.example.healf_mind.components.CaixaDeEntrada
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CadastroScreen(navController: NavController, cadastroScreenViewModel: CadastroScreenViewModel) {
    // var de estado
    val nome by cadastroScreenViewModel.nome.observeAsState(initial = "")
    val email by cadastroScreenViewModel.email.observeAsState(initial = "")
    val senha by cadastroScreenViewModel.senha.observeAsState(initial = "")
//    // Obter contexto atual
    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painterResource(id = R.drawable.tela_login),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )



        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,


            ) {
            Text(
                text = "Para um cuidado \ncompleto com a sua saúde",
                style = TextStyle(
                    fontSize = 22.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,

                    )
            )
            Spacer(modifier = Modifier.height(50.dp))
            Card(
                Modifier
                    .width(340.dp)
                    .height(451.dp)
                    .background(
                        color = Color(0xFFFAFAFA),
                        shape = RoundedCornerShape(size = 70.dp)
                    ),
                elevation = CardDefaults.cardElevation(10.dp),


                ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 20.dp, bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Cadastrar",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.inter_bold)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF005DF9),
                        )
                    )
                    CaixaDeEntrada(
                        label = "Nome",
                        placeholder = "Insira seu nome completo",
                        value = nome,
                        keyboardType = KeyboardType.Text,
                        modifier = Modifier
                            .shadow(
                                elevation = 4.dp,
                                spotColor = Color(0x1A000000),
                                ambientColor = Color(0x1A000000)
                            ),
                        atualizarValor = {
                            cadastroScreenViewModel.onNameChanged(it)
                        },
                        error = false
                    )
                    CaixaDeEntrada(
                        label = "Email",
                        placeholder = "Digite seu Email",
                        value = email,
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier
                            .shadow(
                                elevation = 4.dp,
                                spotColor = Color(0x1A000000),
                                ambientColor = Color(0x1A000000)
                            ),
                        atualizarValor = {
                            cadastroScreenViewModel.onEmailChanged(it)
                        },
                        error = false
                    )
                    CaixaDeEntrada(
                        label = "Senha",
                        placeholder = "Digite uma senha ",
                        value = senha,
                        keyboardType = KeyboardType.Password,
                        modifier = Modifier
                            .shadow(
                                elevation = 4.dp,
                                spotColor = Color(0x1A000000),
                                ambientColor = Color(0x1A000000)
                            ),
                        atualizarValor = {
                            cadastroScreenViewModel.onSenhaChanged(it)
                        },
                        error = false
                    )
                    Button(
                        onClick = {
                            var call = RetrofitFactory().getUsuarioService().inserirUsuario(
                                nome = nome,
                                email = email,
                                senha = senha
                            )

                            call.enqueue(object : Callback<Usuarios>{
                                override fun onResponse(
                                    call: Call<Usuarios>,
                                    response: Response<Usuarios>
                                ) {
                                    Log.i("C##1", "onResponse: ${response.body()}")
                                }

                                override fun onFailure(call: Call<Usuarios>, t: Throwable) {
                                    Log.i("C##111", "onResponse: ${t.message}")
                                }

                            })
                            //val usuario = Usuarios(id = 0, nome = nome, email = email)
                            //usuarioRepository.salvar(usuario)
                        },
                        Modifier
                            .shadow(
                                elevation = 4.dp,
                                spotColor = Color(0x1A000000),
                                ambientColor = Color(0x1A000000)
                            )
                            .width(231.dp)
                            .height(50.dp)
                            .background(
                                color = Color(0xFF005DF9),
                                shape = RoundedCornerShape(size = 25.dp)
                            )

                    ) {
                        Text(text = "Cadastrar")
                    }
                }

            }
        }
    }
}


//@Preview(showSystemUi =  true , showBackground = true)
//@Composable
//fun CadastroScreenPreview(){
//    CadastroScreen()
//}
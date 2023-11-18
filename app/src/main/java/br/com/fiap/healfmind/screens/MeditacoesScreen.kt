package br.com.fiap.healfmind.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import br.com.fiap.healfmind.components.Header
import br.com.fiap.healfmind.components.MeditacoesItem
import br.com.fiap.healfmind.model.Meditacao
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.service.RetrofitFactory
import br.com.fiap.healfmind.ui.theme.purple_gradient
import com.example.healf_mind.components.CaixaDeEntrada
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeditacoesScreen( navController: NavController , usuarios: Usuarios) {

    var meditacoes by remember { mutableStateOf<List<Meditacao>>(emptyList()) }
    LaunchedEffect(true) {
        val call = RetrofitFactory()
            .getMeditacoesService()
            .getMeditacoes()
        call.enqueue(object : Callback<List<Meditacao>> {
            override fun onResponse(
                call: Call<List<Meditacao>>,
                response: Response<List<Meditacao>>
            ) {
                Log.i("b1221", "onResponse:${response.body()} ")
                meditacoes = response.body()?: emptyList()
            }

            override fun onFailure(call: Call<List<Meditacao>>, t: Throwable) {
                Log.i("x1232", "onFailure:${t.message} ")
            }

        })

    }
    Column (Modifier.padding(bottom = 30.dp)){

        Header(navController = navController , usuarios)



        Column (
            Modifier.padding(start = 16.dp , end = 16.dp ),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Spacer(modifier = Modifier.height(12.dp))
        Card (
                modifier = Modifier
                    .width(350.dp)
                    .height(150.dp)
                    .padding(top = 15.dp, bottom = 15.dp),



                colors = CardDefaults.cardColors(purple_gradient)
            ){
                Text(text = "Medite conosco para uma mente mais calma",
                    Modifier.padding(top = 30.dp),
                    style = TextStyle(
                        fontSize = 21.sp,
                        lineHeight = 23.57.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center),

                )
            }


            CaixaDeEntrada(
                label = "",
                placeholder = "Pesquisar",
                value = "",
                keyboardType = KeyboardType.Text,
                modifier = Modifier
                    .width(450.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFB5B5B5),
                        shape = RoundedCornerShape(size = 5.dp)
                    ),
                atualizarValor = {},
                error = false,
                iconImage = R.drawable.search
            )
            Text(
                text = "Vídeos em destaques da semana",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )

            Box(modifier = Modifier.width(400.dp)
                .height(218.dp)
                .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 5.dp))

            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds
                )
            }

            LazyRow (
                Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth().background(color = Color(0xFFD9E7FF)),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 15.dp)
            ){
            items(meditacoes) {
                    p -> MeditacoesItem(meditacao = p , navController)
            }
        }
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 130.dp),
                Modifier.padding(top = 20.dp),
                //contentPadding = PaddingValues(horizontal = 15.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                for(meditacao in meditacoes){
                    item{
                        val meditacaoItem = Meditacao(meditacao.meditacaoId, meditacao.titulo , meditacao.caminhoArquivo)
                        MeditacoesItem(meditacaoItem , navController )
                    }
                }
            }
        }
    }
}



@Preview(showSystemUi =  true)
@Composable
fun MeditacoesScreenPreview(){

    MeditacoesScreen(  navController = rememberNavController() , usuarios = Usuarios(1,"","", "",""))
}
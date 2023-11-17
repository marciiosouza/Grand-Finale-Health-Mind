package com.example.healf_mind.components

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.healfmind.model.Meditacao
import br.com.fiap.healfmind.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun CardHome(titulo: String , caminhoImagem : Int , navController: NavController , rota: String) {
    ///val rota2 : String = rota
    var rota3 by remember {
        mutableStateOf("")
    }


    Log.i("Primeira var", rota3)
    Card (
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .width(111.dp)
            .height(127.dp)
            .padding(bottom = 5.dp),
        colors = CardDefaults.cardColors(Color(0xFF005DF9)),
        shape = RoundedCornerShape(20.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

            ) {
            Image(
                painter = painterResource(id = caminhoImagem),
                contentDescription = titulo,
                modifier = Modifier
                    .width(29.42029.dp)
                    .height(30.dp)
                    .clickable(onClick = {

                        navController.navigate(rota)
                    })
            )

            Text(
                text = titulo,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center

                )
            )
        }
    }
}
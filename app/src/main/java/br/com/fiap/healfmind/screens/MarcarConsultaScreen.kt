package br.com.fiap.healfmind.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.viewModel.MarcarConsultaScreenViewModel
import com.example.healf_mind.components.CaixaDeEntrada

@Composable
fun MarcarConsultaScreen( marcarConsultaScreenViewModel: MarcarConsultaScreenViewModel ) {

    val tipoConsulta by marcarConsultaScreenViewModel.tipoConsulta.observeAsState(initial = "")


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card(
            Modifier
                .width(340.dp)
                .height(266.dp)
                .padding(top = 20.dp),
            colors = CardDefaults.cardColors(Color(0xFFFA0505)),

            ) {

        }

        Text(
            text = "Escolha a sua especialidade",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),


                )
        )
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            CaixaDeEntrada(
                label = "Presencia ou online",
                placeholder = "Presencia ou online",
                value = tipoConsulta,
                keyboardType = KeyboardType.Text,
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    ),
                atualizarValor = {},
                error = false
            )
            CaixaDeEntrada(
                label = "Presencia ou online",
                placeholder = "Presencia ou online",
                value = "teste",
                keyboardType = KeyboardType.Text,
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    ),
                atualizarValor = {},
                error = false
            )

            TextButton(
                onClick = { /*TODO*/ },
                Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    )
                    .width(370.dp)
                    .height(50.dp)
                    .padding(top = 10.dp)
                    .background(color = Color(0xFF005DF9), shape = RoundedCornerShape(size = 25.dp))
            ) {
                Text(
                    text = "agendar",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
        }
    }
}


@Preview(showSystemUi =  true , showBackground = true)
@Composable
fun CadastroScreenPreview(){
    MarcarConsultaScreen(MarcarConsultaScreenViewModel())
}
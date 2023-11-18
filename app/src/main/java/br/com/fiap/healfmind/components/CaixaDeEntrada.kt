package com.example.healf_mind.components

import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.healfmind.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeEntrada(
    label: String,
    placeholder: String,
    value: String,
    keyboardType: KeyboardType,
    modifier: Modifier,
    atualizarValor: (String) -> Unit ,// Função retorna nada
    error : Boolean,
    iconImage : Int
) {
    OutlinedTextField(
        modifier = Modifier
            .width(300.dp)
            .height(56.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 5.dp))
            .border(0.dp, Color.Transparent),
        value = value,
        onValueChange = {
            atualizarValor
        },

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) ,

        leadingIcon = {
            Icon(
                painter = painterResource(id = iconImage),
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp).size(15.dp) // Ajuste o espaçamento conforme necessário
            )
        },
//        Image(
//            painter = painterResource(id = iconImage),
//            contentDescription = "image description",
//            contentScale = ContentScale.None
//        ),

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

}

@Preview
@Composable
fun CaixaDeEntradaPreview() {
    CaixaDeEntrada(label = "Presencia ou online",
        placeholder = "Presencia ou online",
        value = "tipoConsulta",
        keyboardType = KeyboardType.Text,
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            ),
        atualizarValor = {},
        error = false, 1)
}

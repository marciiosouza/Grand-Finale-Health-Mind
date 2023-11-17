package com.example.healf_mind.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.model.Usuarios
import br.com.fiap.healfmind.screens.PerfilScreen
import java.lang.Error

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeEntrada(
    label: String,
    placeholder: String,
    value: String,
    keyboardType: KeyboardType,
    modifier: Modifier,
    atualizarValor: (String) -> Unit ,// Função retorna nada
    error : Boolean
) {


    OutlinedTextField(modifier = Modifier
        .width(303.dp)
        .height(50.dp)
        .background(
            color = Color(0xFFFAFAFA),
            shape = RoundedCornerShape(size = 10.dp)
        )
        .border(0.dp, Color.Transparent),

        value = value,
        onValueChange = {
            atualizarValor

        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) ,
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


//    OutlinedTextField(
//        value = value,
//        onValueChange = atualizarValor,
//        modifier = modifier,
//        label = {
//            Text(text = label)
//        },
//        placeholder = {
//            Text(text = placeholder)
//        },
//
//        shape = RoundedCornerShape(5.dp),
//        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
//        isError = error
//    )
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
        error = false)
}

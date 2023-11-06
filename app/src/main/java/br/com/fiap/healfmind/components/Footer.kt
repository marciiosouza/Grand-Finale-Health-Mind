package br.com.fiap.healfmind.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.healfmind.R

@Composable
fun Footer() {

    Row (
        Modifier.fillMaxWidth().padding(start = 10.dp , end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Image(painter = painterResource(id = R.drawable.homefooter), contentDescription = null,Modifier.size(35.dp) )
        Image(painter = painterResource(id = R.drawable.consultas), contentDescription = null,Modifier.size(35.dp))
        Image(painter = painterResource(id = R.drawable.meditacao), contentDescription = null,Modifier.size(35.dp))
        Image(painter = painterResource(id = R.drawable.sono), contentDescription = null,Modifier.size(35.dp))
        Image(painter = painterResource(id = R.drawable.perfilcomp), contentDescription = null,Modifier.size(35.dp))
    }
}




@Preview(showSystemUi =  true)
@Composable
fun FooterPreview(){
    Footer()
}
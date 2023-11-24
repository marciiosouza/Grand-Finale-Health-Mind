package br.com.fiap.healfmind.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import br.com.fiap.healfmind.model.Meditacao
import br.com.fiap.healfmind.service.RetrofitFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

@Composable
fun VideoPlayerScreen(meditacaoId : String ) {


    var numberId = meditacaoId.toInt()
    Log.i("VideoPlayer", "VideoPlayerScreen:${meditacaoId} ")
    var meditacao by remember { mutableStateOf(Meditacao(0,"","" , "")) }
    LaunchedEffect(true) {
        val call = RetrofitFactory()
            .getMeditacoesService()
            .pesquisarPorId(numberId)
        call.enqueue(object : Callback<Meditacao> {
            override fun onResponse(
                call: Call<Meditacao>,
                response: Response<Meditacao>
            ) {

                Log.i("RespostaVideo", "onResponse:${response.body()} ")
                meditacao = response.body()!!
                Log.i("RespostaVideo2", "onResponse:${meditacao} ")
            }

            override fun onFailure(call: Call<Meditacao>, t: Throwable) {
                Log.i("x1232", "onFailure:${t.message} ")
            }

        })

    }

        val videoUrl = meditacao.urlVideo
        val context = LocalContext.current
        val player = ExoPlayer.Builder(context).build()
        val playerView = PlayerView(context)
        val mediaItem = com.google.android.exoplayer2.MediaItem.fromUri(videoUrl)

        val playWhenReay by remember {
            mutableStateOf(true)
        }

        player.setMediaItem(mediaItem)
        playerView.player = player

        LaunchedEffect(player) {
            player.prepare()
            player.playWhenReady = playWhenReay
        }

        AndroidView(factory = {
            playerView
        })


}
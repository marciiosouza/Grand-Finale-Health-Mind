package br.com.fiap.healfmind.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun VideoPlayerScreen() {

        val videoUrl =
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
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
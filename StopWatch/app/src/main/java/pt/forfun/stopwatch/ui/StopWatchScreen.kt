package pt.forfun.stopwatch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pt.forfun.stopwatch.domain.StopWatch

@Composable
fun StopWatchScreen(watch: StopWatch) {

    var internalWatch by remember { mutableStateOf(watch) }

    LaunchedEffect(key1 = watch) {
        launch {
            while (true) {
                delay(50)
                internalWatch = internalWatch.get()
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            StopWatchView(internalWatch)
            StopWatchControlsView(internalWatch, onStart = {
                internalWatch = internalWatch.start()
            }, onPause = {
                internalWatch = internalWatch.pause()
            }, onReset = {
                internalWatch = internalWatch.reset()
            })
        }
    }
}
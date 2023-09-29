package pt.forfun.stopwatch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pt.forfun.stopwatch.domain.StopWatch
import pt.forfun.stopwatch.ui.components.RoundButton

@Composable
fun StopWatchControlsView(
    watch: StopWatch,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onReset: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        RoundButton(onStart, !watch.isRunning) {
            Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "Start")
        }

        RoundButton(onClick = if (watch.isRunning) onPause else onReset, enabled = !watch.totalRunTime.isZero) {
            Icon(
                imageVector = if (watch.isRunning) Icons.Filled.Pause else Icons.Filled.Stop,
                contentDescription = "Pause/Stop"
            )
        }
    }
}
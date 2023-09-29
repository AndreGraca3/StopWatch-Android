package pt.forfun.stopwatch.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.forfun.stopwatch.domain.StopWatch

@Composable
fun StopWatchView(stopWatch: StopWatch) {
    Row {
        Text(text = stopWatch.time, fontSize = 48.sp)
    }
}
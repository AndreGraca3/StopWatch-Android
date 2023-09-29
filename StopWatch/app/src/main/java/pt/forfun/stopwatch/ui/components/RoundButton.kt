package pt.forfun.stopwatch.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoundButton(onClick: () -> Unit, enabled:Boolean = true, content: @Composable () -> Unit = {}) {
    OutlinedButton(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier= Modifier.size(60.dp),
        contentPadding = PaddingValues(0.dp),
        border = BorderStroke(3.dp, Color.White),
        colors = ButtonDefaults.outlinedButtonColors(Color.hsl(30f, 1f, 0.5f))
    ) {
        content()
    }
}
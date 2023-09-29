package pt.forfun.stopwatch.domain

import java.time.Duration
import java.time.LocalDateTime

data class StopWatch(
    private val startTime: LocalDateTime? = null,
    val totalRunTime: Duration = Duration.ZERO
) {

    fun start(): StopWatch {
        if (isRunning) return this
        return StopWatch(LocalDateTime.now(), totalRunTime)
    }

    fun pause(): StopWatch {
        if (!isRunning) return this
        val runTime = Duration.between(startTime, LocalDateTime.now())
        return StopWatch(null, totalRunTime.plus(runTime))
    }

    fun reset(): StopWatch {
        return StopWatch()
    }

    val isRunning: Boolean
        get() = startTime != null

    fun get(): StopWatch {
        val currentDuration =
            if (isRunning) totalRunTime.plus(
                Duration.between(
                    startTime,
                    LocalDateTime.now()
                )
            ) else totalRunTime

        return StopWatch(if (isRunning) LocalDateTime.now() else startTime, currentDuration)
    }

    val time
        get() = formatter(this.totalRunTime)

    private fun formatter(duration: Duration): String {
        val milliseconds = duration.toMillis() % 1000
        val seconds = duration.seconds % 60
        val minutes = duration.toMinutes() % 60
        val hours = duration.toHours()

        // Check if there are hours in the duration
        return if (hours > 0) {
            String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, milliseconds)
        } else {
            String.format("%02d:%02d:%03d", minutes, seconds, milliseconds)
        }
    }
}
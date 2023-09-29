package pt.forfun.stopwatch.domain

import junit.framework.TestCase.assertEquals
import org.junit.Test

class StopWatchTests {

    @Test
    fun testStart() {
        val stopWatch = StopWatch().start()
        assertEquals("00:00:00", stopWatch.time)
        Thread.sleep(1000)
        assertEquals("00:00:01", stopWatch.time)
    }

    @Test
    fun testPause() {
        var stopWatch = StopWatch().start()
        Thread.sleep(1000)
        assertEquals("00:00:01", stopWatch.time)
        stopWatch = stopWatch.pause()
        Thread.sleep(1000)
        assertEquals("00:00:01", stopWatch.time)
    }

    @Test
    fun testReset() {
        var stopWatch = StopWatch().start()
        Thread.sleep(1000)
        assertEquals("00:00:01", stopWatch.time)
        stopWatch = stopWatch.reset()
        assertEquals("00:00:00", stopWatch.time)
    }

    @Test
    fun testResumeAfterPause() {
        var stopWatch = StopWatch().start()
        Thread.sleep(1000)
        assertEquals("00:00:01", stopWatch.time)
        stopWatch = stopWatch.pause()
        Thread.sleep(1000)
        assertEquals("00:00:01", stopWatch.time)
        stopWatch = stopWatch.start()
        Thread.sleep(1000)
        assertEquals("00:00:02", stopWatch.time)
    }
}
package com.wakemeintime.dffc.wakemeintime

import android.net.TrafficStats
import org.junit.Test
import com.wakemeintime.dffc.wakemeintime.database.TrafficData
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TrafficDataUnitTest {
    @Test
    fun travelTimeHours_isCorrect0() {
        val tdata = TrafficData(500,"mittel");
        assertEquals(500/60, tdata.getTravelTimeHours())
    }
    @Test
    fun travelTimeHours_isCorrect1() {
        val tdata = TrafficData(500,"mittel");
        assertEquals(500, tdata.getTravelTimeHours())
    }
}

package com.wakemeintime.dffc.wakemeintime

import com.wakemeintime.dffc.wakemeintime.database.Calendar
import com.wakemeintime.dffc.wakemeintime.database.TrafficData
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalendarUnitTest {
    @Test
    fun isActive_isCorrect0() {
        val cal = Calendar("","","");
        assertFalse(cal.IsisActiveValidBoolean())
    }
    @Test
    fun isActive_isCorrect1() {
        val cal = Calendar("","","false");
        assertTrue(cal.IsisActiveValidBoolean())
    }
    @Test
    fun isActive_isCorrect2() {
        val cal = Calendar("","","fals");
        assertTrue(cal.IsisActiveValidBoolean())
    }
}

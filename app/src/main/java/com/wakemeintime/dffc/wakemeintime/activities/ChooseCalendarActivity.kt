package com.wakemeintime.dffc.wakemeintime.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.wakemeintime.dffc.wakemeintime.R
import database.Calendar
import database.DatabaseHelper
import kotlinx.android.synthetic.main.activity_choose_calendar.*
import java.util.*


class ChooseCalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_calendar)
        val dbHelper = DatabaseHelper.getInstance(this)
        val lv = myCalendarsListView as ListView
        if (!dbHelper.allCalendar.listIterator().hasNext()) {
            val cal = Calendar("testName", "testDescription", "false")
            val cal1 = Calendar("testName1", "testDescription1", "true")
            dbHelper.addOrUpdateCalendar(cal)
            dbHelper.addOrUpdateCalendar(cal1)
        }
        val calendarNames = ArrayList<String>()
        val iterate = dbHelper.allCalendar.listIterator()
        while (iterate.hasNext()) {
            calendarNames.add(dbHelper.allCalendar[iterate.nextIndex()].name)
            iterate.next()
        }
        // This is the modified array adapter, it takes the context of the activity as a
        // first parameter and your
        // array as a second parameter.
        val arrayAdapter = choose_calendar_adapter_java(this, dbHelper.allCalendar as ArrayList<Calendar>)
        lv.adapter = arrayAdapter
    }

}

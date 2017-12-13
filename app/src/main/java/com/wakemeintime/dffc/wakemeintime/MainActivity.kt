package com.wakemeintime.dffc.wakemeintime

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        Login.setOnClickListener {
            setContentView(R.layout.activity_login)
        }
        ChooseCalendar.setOnClickListener {
            setContentView(R.layout.activity_choose_calendar)
        }
    }


}

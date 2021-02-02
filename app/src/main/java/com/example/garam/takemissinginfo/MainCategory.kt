package com.example.garam.takemissinginfo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_category.*

class MainCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_category)

        var location = ""

        val items = resources.getStringArray(R.array.city)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,items)

        citySpinner.adapter = adapter

        citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when(p2){
                    0 -> location = items[0]
                    1 -> location = items[1]
                    2 -> location = items[2]
                    3 -> location = items[3]
                    4 -> location = items[4]
                    5 -> location = items[5]
                    6 -> location = items[6]
                    7 -> location = items[7]
                    8 -> location = items[8]
                    9 -> location = items[9]
                }
                imageButtonClickListener(location)

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
        }

    }

    private fun imageButtonClickListener(location: String){
        disableMenu.setOnClickListener {
            nextIntent("DISABLE",location)
        }

        oldManMenu.setOnClickListener {
            nextIntent("OLD_MAN",location)
        }

        lowIncomeMenu.setOnClickListener {
            nextIntent("LOW_INCOME",location)
        }

        childHeadMenu.setOnClickListener {
            nextIntent("BOYS_GIRLS_FAMILY",location)
        }

    }

    private fun nextIntent(menuName: String,location: String){
        val nextIntent = Intent(this,SubClass::class.java)
        nextIntent.putExtra("menuName",menuName)
        nextIntent.putExtra("location",location)
        startActivity(nextIntent)
    }
}
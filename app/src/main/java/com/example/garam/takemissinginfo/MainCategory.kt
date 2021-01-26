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
                    0 -> location = "서울특별시"
                    1 -> location = "경기도"
                    2 -> location = "부산광역시"
                    3 -> location = "대전광역시"
                    4 -> location = "대구광역시"
                    5 -> location = "광주광역시"
                    6 -> location = "경상남도"
                    7 -> location = "경상북도"
                    8 -> location = "강원도"
                    9 -> location = "세종특별자치시"
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
            nextIntent("장애인",location)
        }

        oldManMenu.setOnClickListener {
            nextIntent("노인",location)
        }

        lowIncomeMenu.setOnClickListener {
            nextIntent("저소득층",location)
        }

        childHeadMenu.setOnClickListener {
            nextIntent("소년소녀 가장",location)
        }

    }

    private fun nextIntent(menuName: String,location: String){
        val nextIntent = Intent(this,SubClass::class.java)
        nextIntent.putExtra("menuName",menuName)
        nextIntent.putExtra("location",location)
        startActivity(nextIntent)
    }
}
package com.example.garam.takemissinginfo.benefit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.garam.takemissinginfo.R
import kotlinx.android.synthetic.main.activity_main_category.*

class MainCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_category)

        imageButtonClickListener()
    }

    private fun imageButtonClickListener(){

        disableMenu.setOnClickListener {
            nextIntent("DISABLE")
        }

        oldManMenu.setOnClickListener {
            nextIntent("OLD_MAN")
        }

        lowIncomeMenu.setOnClickListener {
            nextIntent("LOW_INCOME")
        }

        childHeadMenu.setOnClickListener {
            nextIntent("BOYS_GIRLS_FAMILY")
        }

    }

    private fun nextIntent(menuName: String){
        val nextIntent = Intent(this, SubClass::class.java)
        nextIntent.putExtra("menuName",menuName)
        startActivity(nextIntent)
    }
}
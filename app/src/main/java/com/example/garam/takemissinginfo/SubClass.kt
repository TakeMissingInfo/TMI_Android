package com.example.garam.takemissinginfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SubClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_class)
        val intent = intent
        val menuName = intent.getStringExtra("menuName")
        val location = intent.getStringExtra("location")
        Toast.makeText(this,"$menuName , $location", Toast.LENGTH_SHORT).show()
    }
}
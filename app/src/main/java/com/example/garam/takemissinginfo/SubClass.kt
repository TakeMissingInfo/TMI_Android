package com.example.garam.takemissinginfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.garam.takemissinginfo.network.NetworkController
import com.example.garam.takemissinginfo.network.NetworkService
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_sub_class.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class SubClass : AppCompatActivity() {

    private val networkService: NetworkService by lazy {
        NetworkController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_class)
        val intent = intent
        val menuName = intent.getStringExtra("menuName")
        val location = intent.getStringExtra("location")
        Toast.makeText(this,"$menuName , $location", Toast.LENGTH_SHORT).show()

        val benefitArray = ArrayList<String> ()

        class BtnClick : View.OnClickListener {
            override fun onClick(v: View) {
                when(v.id) {
                    employmentButton.id -> {
                        benefitArray.add("EMPLOYMENT")
                        selectedClassTextView.append("${employmentButton.text}/")
                    }

                    financeButton.id -> {
                        benefitArray.add("FINANCE")
                        selectedClassTextView.append("${financeButton.text}/")
                    }

                    lifeButton.id -> {
                        benefitArray.add("LIFE")
                        selectedClassTextView.append("${lifeButton.text}/")

                    }

                    medicalButton.id -> {
                        benefitArray.add("MEDICAL_CARE")
                        selectedClassTextView.append("${medicalButton.text}/")

                    }

                    parentingButton.id -> {
                        benefitArray.add("MARRIAGE_PARENTING")
                        selectedClassTextView.append("${parentingButton.text}/")

                    }

                    environmentButton.id -> {
                        benefitArray.add("ENVIRONMENTAL_DISASTER")
                        selectedClassTextView.append("${environmentButton.text}/")

                    }

                    housingButton.id -> {
                        benefitArray.add("HOUSING")
                        selectedClassTextView.append("${housingButton.text}/")

                    }

                    carButton.id -> {
                        benefitArray.add("MOTOR_TRAFFIC")
                        selectedClassTextView.append("${carButton.text}/")

                    }
                }
            }
        }

        val click = BtnClick()

        employmentButton.setOnClickListener(click)
        financeButton.setOnClickListener(click)
        lifeButton.setOnClickListener(click)
        medicalButton.setOnClickListener(click)
        parentingButton.setOnClickListener(click)
        environmentButton.setOnClickListener(click)
        housingButton.setOnClickListener(click)
        carButton.setOnClickListener(click)

        selectButton.setOnClickListener {
            Log.e("benefit", benefitArray.toString())
            benefit(menuName, benefitArray)
        }



    }

    private fun benefit(type: String?, benefitType: ArrayList<String>){

        networkService.benefitsRequest(type.toString(),benefitType).enqueue(object : Callback<JsonObject>{

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {

            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful) {
                    val res = response.body()

                    Log.e("테스트",res.toString())

                }
            }
        })
    }
}
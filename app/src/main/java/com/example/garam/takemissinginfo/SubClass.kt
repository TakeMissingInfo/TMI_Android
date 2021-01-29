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

        class BtnClick : View.OnClickListener {
            override fun onClick(v: View) {
                when(v.id) {
                    employmentButton.id -> {
                        selectedClassTextView.append("${employmentButton.text}/")
                    }

                    financeButton.id -> {
                        selectedClassTextView.append("${financeButton.text}/")
                    }

                    lifeButton.id -> {
                        selectedClassTextView.append("${lifeButton.text}/")

                    }

                    medicalButton.id -> {
                        selectedClassTextView.append("${medicalButton.text}/")

                    }

                    parentingButton.id -> {
                        selectedClassTextView.append("${parentingButton.text}/")

                    }

                    environmentButton.id -> {
                        selectedClassTextView.append("${environmentButton.text}/")

                    }

                    housingButton.id -> {
                        selectedClassTextView.append("${housingButton.text}/")

                    }

                    carButton.id -> {
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

        benefit(menuName)



    }





    private fun benefit(type: String?){

        val testArray  = arrayOf("LIFE")
        networkService.benefitsRequest(type.toString(),testArray).enqueue(object : Callback<JsonObject>{

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
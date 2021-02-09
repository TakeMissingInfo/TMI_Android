package com.example.garam.takemissinginfo.benefit

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.garam.takemissinginfo.R
import kotlinx.android.synthetic.main.activity_sub_class.*

class SubClass : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_class)
        val intent = intent
        val menuName = intent.getStringExtra("menuName")

        val benefitHashMap = HashMap<String,String> ()

        class BtnClick : View.OnClickListener {
            override fun onClick(v: View) {
                when(v.id) {
                    employmentButton.id -> {
                        if (!employmentButton.isSelected) {
                            employmentButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["EMPLOYMENT"] = "${employmentButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            employmentButton.isSelected = true


                        } else if (employmentButton.isSelected) {
                            employmentButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("EMPLOYMENT")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            employmentButton.isSelected = false

                        }
                    }

                    financeButton.id -> {
                        if (!financeButton.isSelected) {
                            financeButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["FINANCE"] = "${financeButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            financeButton.isSelected = true

                        } else if (financeButton.isSelected) {
                            financeButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("FINANCE")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            financeButton.isSelected = false

                        }
                    }

                    lifeButton.id -> {
                        if (!lifeButton.isSelected) {
                            lifeButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["LIFE"] = "${lifeButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            lifeButton.isSelected = true

                        } else if (lifeButton.isSelected) {
                            lifeButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("LIFE")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            lifeButton.isSelected = false

                        }
                    }

                    medicalButton.id -> {
                        if (!medicalButton.isSelected) {
                            medicalButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["MEDICAL_CARE"] = "${medicalButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            medicalButton.isSelected = true

                        } else if (medicalButton.isSelected){
                            medicalButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("MEDICAL_CARE")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            medicalButton.isSelected = false

                        }
                    }

                    parentingButton.id -> {
                        if (!parentingButton.isSelected) {
                            parentingButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["MARRIAGE_PARENTING"] = "${parentingButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            parentingButton.isSelected = true

                        } else if(parentingButton.isSelected){
                            parentingButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("MARRIAGE_PARENTING")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            parentingButton.isSelected = false

                        }
                    }

                    environmentButton.id -> {
                        if (!environmentButton.isSelected) {
                            environmentButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["ENVIRONMENTAL_DISASTER"] = "${environmentButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            environmentButton.isSelected = true

                        } else if (environmentButton.isSelected){
                            environmentButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("ENVIRONMENTAL_DISASTER")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            environmentButton.isSelected = false

                        }
                    }

                    housingButton.id -> {
                        if (!housingButton.isSelected) {
                            housingButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["HOUSING"] = "${housingButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            housingButton.isSelected = true

                        } else if (housingButton.isSelected){
                            housingButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("HOUSING")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            housingButton.isSelected = false

                        }
                    }

                    carButton.id -> {

                        if (!carButton.isSelected){
                            carButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["MOTOR_TRAFFIC"] = "${carButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            carButton.isSelected = true

                        } else if (carButton.isSelected){
                            carButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("MOTOR_TRAFFIC")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            carButton.isSelected = false
                        }
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

            val nextIntent = Intent(this, BenefitInfoActivity::class.java)
            nextIntent.putExtra("type",menuName)
            nextIntent.putExtra("benefitType",benefitHashMap)

            startActivity(nextIntent)
        }
    }

}
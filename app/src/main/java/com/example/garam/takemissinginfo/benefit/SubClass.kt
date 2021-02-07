package com.example.garam.takemissinginfo.benefit

import android.content.Intent
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

                            benefitHashMap["EMPLOYMENT"] = "${employmentButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            employmentButton.isSelected = true

                        } else if (employmentButton.isSelected) {

                            benefitHashMap.remove("EMPLOYMENT")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            employmentButton.isSelected = false

                        }
                    }

                    financeButton.id -> {
                        if (!financeButton.isSelected) {

                            benefitHashMap["FINANCE"] = "${financeButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            financeButton.isSelected = true

                        } else if (financeButton.isSelected) {

                            benefitHashMap.remove("FINANCE")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            financeButton.isSelected = false

                        }
                    }

                    lifeButton.id -> {
                        if (!lifeButton.isSelected) {

                            benefitHashMap["LIFE"] = "${lifeButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            lifeButton.isSelected = true

                        } else if (lifeButton.isSelected) {

                            benefitHashMap.remove("LIFE")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            lifeButton.isSelected = false

                        }
                    }

                    medicalButton.id -> {
                        if (!medicalButton.isSelected) {

                            benefitHashMap["MEDICAL_CARE"] = "${medicalButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            medicalButton.isSelected = true

                        } else if (medicalButton.isSelected){

                            benefitHashMap.remove("MEDICAL_CARE")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            medicalButton.isSelected = false

                        }
                    }

                    parentingButton.id -> {
                        if (!parentingButton.isSelected) {

                            benefitHashMap["MARRIAGE_PARENTING"] = "${parentingButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            parentingButton.isSelected = true

                        } else if(parentingButton.isSelected){

                            benefitHashMap.remove("MARRIAGE_PARENTING")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            parentingButton.isSelected = false

                        }
                    }

                    environmentButton.id -> {
                        if (!environmentButton.isSelected) {

                            benefitHashMap["ENVIRONMENTAL_DISASTER"] = "${environmentButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            environmentButton.isSelected = true

                        } else if (environmentButton.isSelected){

                            benefitHashMap.remove("ENVIRONMENTAL_DISASTER")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            environmentButton.isSelected = false

                        }
                    }

                    housingButton.id -> {
                        if (!housingButton.isSelected) {

                            benefitHashMap["HOUSING"] = "${housingButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            housingButton.isSelected = true

                        } else if (housingButton.isSelected){

                            benefitHashMap.remove("HOUSING")
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            housingButton.isSelected = false

                        }
                    }

                    carButton.id -> {

                        if (!carButton.isSelected){

                            benefitHashMap["MOTOR_TRAFFIC"] = "${carButton.text}"
                            selectedClassTextView.text = benefitHashMap.values.toString()
                            carButton.isSelected = true

                        } else {

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
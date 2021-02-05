package com.example.garam.takemissinginfo.benefit

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.garam.takemissinginfo.R
import kotlinx.android.synthetic.main.activity_sub_class.*
import kotlin.reflect.typeOf

class SubClass : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_class)
        val intent = intent
        val menuName = intent.getStringExtra("menuName")

        val benefitArray = ArrayList<String> ()
        val testArray = HashMap<String,String> ()

        class BtnClick : View.OnClickListener {
            override fun onClick(v: View) {
                when(v.id) {
                    employmentButton.id -> {
                        if (!employmentButton.isSelected) {

                            benefitArray.add("EMPLOYMENT")
                            testArray["EMPLOYMENT"] = "${employmentButton.text}"
                            selectedClassTextView.text = testArray.values.toString()
                            employmentButton.isSelected = true

                        } else if (employmentButton.isSelected) {

                            benefitArray.remove("EMPLOYMENT")
                            testArray.remove("EMPLOYMENT")
                            selectedClassTextView.text = testArray.values.toString()
                            employmentButton.isSelected = false

                        }
                    }

                    financeButton.id -> {
                        if (!financeButton.isSelected) {

                            benefitArray.add("FINANCE")
                            testArray["FINANCE"] = "${financeButton.text}"
                            selectedClassTextView.text = testArray.values.toString()
                            financeButton.isSelected = true

                        } else if (financeButton.isSelected) {

                            benefitArray.remove("FINANCE")
                            testArray.remove("FINANCE")
                            selectedClassTextView.text = testArray.values.toString()
                            financeButton.isSelected = false

                        }
                    }

                    lifeButton.id -> {
                        if (!lifeButton.isSelected) {

                            benefitArray.add("LIFE")
                            testArray["LIFE"] = "${lifeButton.text}"
                            selectedClassTextView.text = testArray.values.toString()
                            lifeButton.isSelected = true

                        } else if (lifeButton.isSelected) {

                            benefitArray.remove("LIFE")
                            testArray.remove("LIFE")
                            selectedClassTextView.text = testArray.values.toString()
                            lifeButton.isSelected = false

                        }
                    }

                    medicalButton.id -> {
                        if (!medicalButton.isSelected) {

                            benefitArray.add("MEDICAL_CARE")
                            testArray["MEDICAL_CARE"] = "${medicalButton.text}"
                            selectedClassTextView.text = testArray.values.toString()
                            medicalButton.isSelected = true

                        } else if (medicalButton.isSelected){

                            benefitArray.remove("MEDICAL_CARE")
                            testArray.remove("MEDICAL_CARE")
                            selectedClassTextView.text = testArray.values.toString()
                            medicalButton.isSelected = false

                        }
                    }

                    parentingButton.id -> {
                        if (!parentingButton.isSelected) {

                            benefitArray.add("MARRIAGE_PARENTING")
                            testArray["MARRIAGE_PARENTING"] = "${parentingButton.text}"
                            selectedClassTextView.text = testArray.values.toString()
                            parentingButton.isSelected = true

                        } else if(parentingButton.isSelected){

                            benefitArray.remove("MARRIAGE_PARENTING")
                            testArray.remove("MARRIAGE_PARENTING")
                            selectedClassTextView.text = testArray.values.toString()
                            parentingButton.isSelected = false

                        }
                    }

                    environmentButton.id -> {
                        if (!environmentButton.isSelected) {

                            benefitArray.add("ENVIRONMENTAL_DISASTER")
                            testArray["ENVIRONMENTAL_DISASTER"] = "${environmentButton.text}"
                            selectedClassTextView.text = testArray.values.toString()
                            environmentButton.isSelected = true

                        } else if (environmentButton.isSelected){

                            benefitArray.remove("ENVIRONMENTAL_DISASTER")
                            testArray.remove("ENVIRONMENTAL_DISASTER")
                            selectedClassTextView.text = testArray.values.toString()
                            environmentButton.isSelected = false

                        }
                    }

                    housingButton.id -> {
                        if (!housingButton.isSelected) {

                            benefitArray.add("HOUSING")
                            testArray["HOUSING"] = "${housingButton.text}"
                            selectedClassTextView.text = testArray.values.toString()
                            housingButton.isSelected = true

                        } else if (housingButton.isSelected){

                            benefitArray.remove("HOUSING")
                            testArray.remove("HOUSING")
                            selectedClassTextView.text = testArray.values.toString()
                            housingButton.isSelected = false

                        }
                    }

                    carButton.id -> {

                        if (!carButton.isSelected){

                            benefitArray.add("MOTOR_TRAFFIC")
                            testArray["MOTOR_TRAFFIC"] = "${carButton.text}"
                            selectedClassTextView.text = testArray.values.toString()
                            carButton.isSelected = true

                        } else {

                            benefitArray.remove("MOTOR_TRAFFIC")
                            testArray.remove("MOTOR_TRAFFIC")
                            selectedClassTextView.text = testArray.values.toString()
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
            nextIntent.putExtra("benefitType", benefitArray)
            nextIntent.putExtra("testType",testArray)

            startActivity(nextIntent)
        }
    }

}
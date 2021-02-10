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
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            employmentButton.isSelected = true


                        } else if (employmentButton.isSelected) {
                            employmentButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("EMPLOYMENT")
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            employmentButton.isSelected = false

                        }
                    }

                    financeButton.id -> {
                        if (!financeButton.isSelected) {
                            financeButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["FINANCE"] = "${financeButton.text}"
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            financeButton.isSelected = true

                        } else if (financeButton.isSelected) {
                            financeButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("FINANCE")
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            financeButton.isSelected = false

                        }
                    }

                    lifeButton.id -> {
                        if (!lifeButton.isSelected) {
                            lifeButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["LIFE"] = "${lifeButton.text}"
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            lifeButton.isSelected = true

                        } else if (lifeButton.isSelected) {
                            lifeButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("LIFE")
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            lifeButton.isSelected = false

                        }
                    }

                    medicalButton.id -> {
                        if (!medicalButton.isSelected) {
                            medicalButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["MEDICAL_CARE"] = "${medicalButton.text}"
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            medicalButton.isSelected = true

                        } else if (medicalButton.isSelected){
                            medicalButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("MEDICAL_CARE")
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            medicalButton.isSelected = false

                        }
                    }

                    parentingButton.id -> {
                        if (!parentingButton.isSelected) {
                            parentingButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["MARRIAGE_PARENTING"] = "${parentingButton.text}"
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            parentingButton.isSelected = true

                        } else if(parentingButton.isSelected){
                            parentingButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("MARRIAGE_PARENTING")
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            parentingButton.isSelected = false

                        }
                    }

                    environmentButton.id -> {
                        if (!environmentButton.isSelected) {
                            environmentButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["ENVIRONMENTAL_DISASTER"] = "${environmentButton.text}"
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            environmentButton.isSelected = true

                        } else if (environmentButton.isSelected){
                            environmentButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("ENVIRONMENTAL_DISASTER")
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            environmentButton.isSelected = false

                        }
                    }

                    housingButton.id -> {
                        if (!housingButton.isSelected) {
                            housingButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["HOUSING"] = "${housingButton.text}"
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            housingButton.isSelected = true

                        } else if (housingButton.isSelected){
                            housingButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("HOUSING")
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            housingButton.isSelected = false

                        }
                    }

                    carButton.id -> {

                        if (!carButton.isSelected){
                            carButton.setTextColor(Color.rgb(107,8,49))
                            benefitHashMap["MOTOR_TRAFFIC"] = "${carButton.text}"
                            selectedClassTextView.text = selectedText(benefitHashMap)
                            carButton.isSelected = true

                        } else if (carButton.isSelected){
                            carButton.setTextColor(Color.BLACK)
                            benefitHashMap.remove("MOTOR_TRAFFIC")
                            selectedClassTextView.text = selectedText(benefitHashMap)
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

    private fun selectedText(hashMap: HashMap<String,String>) : String {
        return if (hashMap.isEmpty()) ""
        else hashMap.values.toString()
    }

}
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

        val textColor = Color.rgb(107,8,49)

        val benefitHashMap = HashMap<String,String> ()

        class BtnClick : View.OnClickListener {
            override fun onClick(v: View) {
                when(v.id) {

                    employmentButton.id -> {
                        when (employmentButton.isSelected) {
                            false -> {
                                employmentButton.setTextColor(textColor)
                                benefitHashMap["EMPLOYMENT"] = "${employmentButton.text}"
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                employmentButton.isSelected = true

                            }
                            true -> {
                                employmentButton.setTextColor(Color.BLACK)
                                benefitHashMap.remove("EMPLOYMENT")
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                employmentButton.isSelected = false
                            }
                        }
                    }

                    financeButton.id -> {
                        when (financeButton.isSelected) {
                            false ->{
                                financeButton.setTextColor(textColor)
                                benefitHashMap["FINANCE"] = "${financeButton.text}"
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                financeButton.isSelected = true

                        }
                            true -> {
                                financeButton.setTextColor(Color.BLACK)
                                benefitHashMap.remove("FINANCE")
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                financeButton.isSelected = false
                            }
                        }
                    }

                    lifeButton.id -> {
                        when (lifeButton.isSelected) {
                            false -> {
                                lifeButton.setTextColor(textColor)
                                benefitHashMap["LIFE"] = "${lifeButton.text}"
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                lifeButton.isSelected = true

                            }
                            true -> {
                                lifeButton.setTextColor(Color.BLACK)
                                benefitHashMap.remove("LIFE")
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                lifeButton.isSelected = false

                            }
                        }
                    }

                    medicalButton.id -> {
                        when (medicalButton.isSelected) {

                            false -> {
                                medicalButton.setTextColor(textColor)
                                benefitHashMap["MEDICAL_CARE"] = "${medicalButton.text}"
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                medicalButton.isSelected = true
                            }
                            true -> {
                                medicalButton.setTextColor(Color.BLACK)
                                benefitHashMap.remove("MEDICAL_CARE")
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                medicalButton.isSelected = false

                            }
                        }
                    }

                    parentingButton.id -> {
                        when (parentingButton.isSelected) {
                            false -> {
                                parentingButton.setTextColor(textColor)
                                benefitHashMap["MARRIAGE_PARENTING"] = "${parentingButton.text}"
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                parentingButton.isSelected = true

                            }
                            true -> {
                                parentingButton.setTextColor(Color.BLACK)
                                benefitHashMap.remove("MARRIAGE_PARENTING")
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                parentingButton.isSelected = false

                            }
                        }
                    }

                    environmentButton.id -> {
                        when (environmentButton.isSelected) {
                            false -> {
                                environmentButton.setTextColor(textColor)
                                benefitHashMap["ENVIRONMENTAL_DISASTER"] = "${environmentButton.text}"
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                environmentButton.isSelected = true

                            }
                            true -> {
                                environmentButton.setTextColor(Color.BLACK)
                                benefitHashMap.remove("ENVIRONMENTAL_DISASTER")
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                environmentButton.isSelected = false

                            }
                        }
                    }

                    housingButton.id -> {
                        when (housingButton.isSelected){
                            false -> {
                                housingButton.setTextColor(textColor)
                                benefitHashMap["HOUSING"] = "${housingButton.text}"
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                housingButton.isSelected = true

                            }
                            true -> {
                                housingButton.setTextColor(Color.BLACK)
                                benefitHashMap.remove("HOUSING")
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                housingButton.isSelected = false
                            }
                        }
                    }

                    carButton.id -> {

                        when (carButton.isSelected){
                            false ->{
                                carButton.setTextColor(textColor)
                                benefitHashMap["MOTOR_TRAFFIC"] = "${carButton.text}"
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                carButton.isSelected = true

                            }
                            true -> {
                                carButton.setTextColor(Color.BLACK)
                                benefitHashMap.remove("MOTOR_TRAFFIC")
                                selectedClassTextView.text = selectedText(benefitHashMap)
                                carButton.isSelected = false
                            }
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
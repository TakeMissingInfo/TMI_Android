package com.example.garam.takemissinginfo.benefit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.garam.takemissinginfo.R
import com.example.garam.takemissinginfo.network.NetworkController
import com.example.garam.takemissinginfo.network.NetworkService
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BenefitInfoActivity : AppCompatActivity() {

    private val networkService: NetworkService by lazy {
        NetworkController.instance.networkService
    }

    private lateinit var benefitRecycler : BenefitRecyclerViewAdapter
    private var lists = arrayListOf<BenefitInfoData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benefit_info)

        val intent = intent
        val type = intent.getStringExtra("type")
        val benefitType = intent.getSerializableExtra("benefitType")
        val benefitTypeHashMap = benefitType as HashMap<String, String>
        val benefitList = ArrayList(benefitTypeHashMap.keys)

        benefit(type, benefitList)

        val recycler = findViewById<RecyclerView>(R.id.benefitRecycler)

        benefitRecycler =
            BenefitRecyclerViewAdapter(
                lists,
                this
            ) { BenefitInfoData ->

                val nextIntent = Intent(
                    this,
                    BenefitWebViewActivity::class.java
                )
                nextIntent.putExtra("detailUrl", BenefitInfoData.detailsInfoUrl)
                startActivity(nextIntent)

            }

        recycler.adapter = benefitRecycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
    }

    private fun benefit(type: String?, benefitType: ArrayList<String>){

        val failMessage = Toast.makeText(this,"혜택 조회에 실패했습니다",Toast.LENGTH_SHORT)

        networkService.benefitsRequest(type.toString(),benefitType).enqueue(object : Callback<JsonObject> {

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                failMessage.show()
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val data = responseBody?.get("data")?.asJsonArray

                    for ( i in 0 until data?.size()!!) {
                        val competentInstitution =
                            data[i]?.asJsonObject?.get("competentInstitution")?.asString.toString()
                        val detailsInfo = data[i]?.asJsonObject?.get("detailsInfo")?.asString.toString()
                        val detailsInfoUrl = data[i]?.asJsonObject?.get("detailsInfoUrl")?.asString.toString()
                        val benefitName = data[i]?.asJsonObject?.get("name")?.asString.toString()
                        val supportForm = data[i]?.asJsonObject?.get("supportForm")?.asString.toString()

                        lists.add(BenefitInfoData(competentInstitution, detailsInfo, detailsInfoUrl,
                                benefitName, supportForm))
                    }
                } else if (!response.isSuccessful) { failMessage.show() }

                benefitRecycler.notifyDataSetChanged()
            }
        })
    }
}
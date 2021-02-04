package com.example.garam.takemissinginfo.benefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.garam.takemissinginfo.R
import kotlinx.android.synthetic.main.activity_benefit_web_view.*

class BenefitWebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benefit_web_view)

        val intent = intent
        val detailUrl = intent.getStringExtra("detailUrl")

        benefitWebView.webViewClient = WebViewClient()
        benefitWebView.loadUrl(detailUrl)
    }
}
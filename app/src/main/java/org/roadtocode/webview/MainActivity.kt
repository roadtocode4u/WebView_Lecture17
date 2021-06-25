package org.roadtocode.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         myWebView = findViewById(R.id.myWebView)

        val etURL: EditText = findViewById(R.id.etUrl)
        val btnGo: Button = findViewById(R.id.btnGo)

        myWebView.webViewClient= WebViewClient()

        myWebView.loadUrl("file:///android_asset/index.html")

        btnGo.setOnClickListener {
            val siteUrl: String = etURL.text.toString()

            if(URLUtil.isValidUrl(siteUrl))
            {
                myWebView.loadUrl(siteUrl)
            }
            else
            {
                myWebView.loadUrl("https://www.google.com/search?q=$siteUrl")
            }
        }

        myWebView.settings.javaScriptEnabled = true

    }

    override fun onBackPressed() {
        if(myWebView.canGoBack())
        {
            myWebView.goBack()
        }
        else
        {
            super.onBackPressed()
        }
    }
}
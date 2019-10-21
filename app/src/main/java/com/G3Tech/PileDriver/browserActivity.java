package com.G3Tech.PileDriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class browserActivity extends AppCompatActivity {

    protected WebView myWebView;
    protected String Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        Intent intent = getIntent();
        Url = intent.getStringExtra("Url"); //Gets Url string from Main Activity
        myWebView = (WebView) findViewById(R.id.web1); //initalizes the webview
        myWebView.getSettings().setJavaScriptEnabled(true);

        createWebApp(myWebView);
        myWebView.loadUrl(Url); //Sets webview Url
    }

    //Creates webview client to display webpage in app
    protected void createWebApp(WebView myWebView) {
        myWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView web1, String url) {
                return false;
            }

        });
    }
}

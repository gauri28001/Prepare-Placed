package com.appdevelopers3a.prepareplaced;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    private android.webkit.WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (android.webkit.WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(getIntent().getExtras().getString("url"));
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
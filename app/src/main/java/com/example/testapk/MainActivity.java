package com.example.testapk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonOpenGoogle;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOpenGoogle = findViewById(R.id.buttonOpenGoogle);
        webView = findViewById(R.id.webView);

        // Настройка WebView
        webView.setWebViewClient(new WebViewClient()); // Открываем ссылки внутри WebView
        webView.getSettings().setJavaScriptEnabled(true); // Включаем поддержку JavaScript

        // Обработка нажатия на кнопку "Открыть Google"
        buttonOpenGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Показываем WebView
                webView.setVisibility(View.VISIBLE);

                // Загружаем Google
                webView.loadUrl("https://www.google.com");
            }
        });
    }
}
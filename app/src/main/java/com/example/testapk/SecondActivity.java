package com.example.testapk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textViewName, textViewAge, textViewAccess;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName = findViewById(R.id.textViewName);
        textViewAge = findViewById(R.id.textViewAge);
        textViewAccess = findViewById(R.id.textViewAccess);
        buttonBack = findViewById(R.id.buttonBack);

        // Получаем Intent, который запустил эту Activity
        Intent intent = getIntent();

        // Извлекаем данные из Intent
        String name = intent.getStringExtra("EXTRA_NAME");
        int age = intent.getIntExtra("EXTRA_AGE", 0);

        // Отображаем имя и возраст
        textViewName.setText("Имя: " + name);
        textViewAge.setText("Возраст: " + age);

        // Проверяем возраст и отображаем сообщение
        if (age > 18) {
            textViewAccess.setText("Доступ разрешен");
            textViewAccess.setVisibility(View.VISIBLE);
        }

        // Кнопка для возврата назад
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрываем SecondActivity и возвращаемся к MainActivity
            }
        });
    }
}
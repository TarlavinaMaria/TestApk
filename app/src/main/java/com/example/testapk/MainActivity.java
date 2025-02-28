package com.example.testapk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextAge;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Получаем данные с формы
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        button = findViewById(R.id.buttonGo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Получаем имя и возраст
                String name = editTextName.getText().toString(); // Преобразуем Editable в String
                int age = Integer.parseInt(editTextAge.getText().toString()); // Преобразуем String в int

                // Создаем Intent для перехода на SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Передаем данные в Intent
                intent.putExtra("NAME", name);
                intent.putExtra("AGE", age);

                // Запускаем SecondActivity
                startActivity(intent);
            }
        });
    }
}
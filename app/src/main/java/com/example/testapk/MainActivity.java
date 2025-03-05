package com.example.testapk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String SAVED_TEXT = "saved_text";
    EditText editText;
    Button saveButton;
    Button loadButton;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов интерфейса
        editText = findViewById(R.id.editText);
        saveButton = findViewById(R.id.saveButton);
        loadButton = findViewById(R.id.loadButton);

        // Обработчик кнопки "Сохранить"
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText();
            }
        });

        // Обработчик кнопки "Загрузить"
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadText();
            }
        });
    }

    // Метод для сохранения текста
    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        String load = sPref.getString(SAVED_TEXT, "");
        editText.setText(load);
        Toast.makeText(this, "Текст сохранен", Toast.LENGTH_SHORT).show();
    }

    // Метод для загрузки текста
    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, editText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Текст загружен", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        saveText();
    }
}
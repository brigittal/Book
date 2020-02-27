package com.example.book;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import androidx.appcompat.app.AppCompatActivity;



public class add extends AppCompatActivity {

    Button addbut;
    EditText word;
    EditText trword;
    final static String fileName = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        word = (EditText) findViewById(R.id.word);
        trword = (EditText) findViewById(R.id.trword);
        addbut = (Button) findViewById(R.id.addbut);
        addbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData(fileName,word.getText().toString() + " " + trword.getText().toString() );
                Log.d("LOG", "Файл записан");

            }
        });
    }

    // сохранение файла
    public void saveData(String fileName, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName, MODE_APPEND)));
            writer.write(data);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
package com.example.book;
import android.content.Intent;
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
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


public class AddActivity extends AppCompatActivity {

    Button addbut;
    EditText add_word;
    EditText add_translate;

    //final static String fileName = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        add_word = (EditText) findViewById(R.id.add_word);
        add_translate = (EditText) findViewById(R.id.add_translate);
        addbut = (Button) findViewById(R.id.addbut);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "wordlist")
                .allowMainThreadQueries()
                .build();

        addbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word test = new Word(add_word.getText().toString(), add_translate.getText().toString());
                db.WordDao().insert(test);
                startActivity(new Intent(AddActivity.this, MainActivity.class));
            }
        });
    }
}
           /* @Override
            public void onClick(View view) {
                saveData(fileName,word.getText().toString() + " " + trword.getText().toString() );
                Log.d("LOG", "Файл записан");

            }*/

        //addbut.setOnClickListener(this);

   /* @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("word", word.getText().toString());
        intent.putExtra("trwowr",trword.getText().toString());
        startActivity(intent);
    }*/
    // сохранение файла
   /* public void saveData(String fileName, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName, MODE_APPEND)));
            writer.write(data);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }*/

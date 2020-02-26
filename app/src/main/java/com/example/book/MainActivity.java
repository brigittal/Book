package com.example.book;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;




public class MainActivity extends AppCompatActivity
{
    List<Word> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        DataAdapter adapter = new DataAdapter(this, words);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData()
    {
        words.add(new Word ("Кошка", "Cat"));
        words.add(new Word ("Собака", "Dog"));
        words.add(new Word ("Дом", "House"));
        words.add(new Word ("Свинья", "Pig"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void newWord(MenuItem item) {
        if (item.getItemId() == R.id.menu_item) {
            Intent intent = new Intent(this, add.class);
            startActivity(intent);


        }


    }

}
package com.example.book;

import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;




public class MainActivity extends AppCompatActivity {
    //List<Word> words = new ArrayList<>();
    RecyclerView recyclerView;
    private static final String TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setInitialData();


        /*for (int i = 0; i<100; i++ ){
            Word word = new Word ("кошка #" +i ,"cat");
            words.add(word);

         */
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "wordlist")
                .allowMainThreadQueries()
                .build();
        List<Word> words = db.WordDao().getAll();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewmain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DataAdapter adapter = new DataAdapter(this, words);
        recyclerView.setAdapter(adapter);

        //AppDatabase db = App.getInstance().getDatabase();
        //WordDao wordWork = db.WordDao();
    }



       /* private void setInitialData()
        {
            Intent intent = getIntent();

            String original_word = intent.getStringExtra("word");
            String translate_word = intent.getStringExtra("trword");


            words.add(new Word  (original_word, translate_word));
            words.add(new Word ("Собака ", "Dog"));
            words.add(new Word ("Дом ", "House"));
            words.add(new Word ("Свинья ", "Pig"));
            words.add(new Word ("Кошка ", "Cat"));
            words.add(new Word ("Собака ", "Dog"));
            words.add(new Word ("Дом ", "House"));
            words.add(new Word ("Свинья ", "Pig"));
            words.add(new Word ("Кошка ", "Cat"));
            words.add(new Word ("Собака ", "Dog"));
            words.add(new Word ("Дом ", "House"));
            words.add(new Word ("Свинья ", "Pig"));
        }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void newWord(MenuItem item) {
        if (item.getItemId() == R.id.menu_item) {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
        }
    }

}

    /*public String readData(String fileName){
       try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));

            String line = "";
            While((line = reader.readLine())!=null){
                return line;
            };

        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
            catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }*/




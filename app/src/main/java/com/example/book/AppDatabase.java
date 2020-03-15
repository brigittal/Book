package com.example.book;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// основной класс по работе с базой данных
@Database(entities = {Word.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
   public abstract WordDao WordDao();
}

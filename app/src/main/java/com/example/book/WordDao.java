package com.example.book;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao //В объекте Dao мы будем описывать методы для работы с базой данных.
public interface WordDao {
    @Query("SELECT * FROM word")
    List<Word> getAll(); //Метод getAll позволяет получить полный список слов

    @Query("SELECT * FROM word WHERE id = :id")
    Word getById(long id); //Метод getById позволяет получить конкретное слово по id

    @Insert
    void insert(Word word); //вставка

    @Update
    void update(Word word);//обновление

    @Delete
    void delete(Word word);//удаление

}

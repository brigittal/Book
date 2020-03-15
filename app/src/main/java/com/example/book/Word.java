package com.example.book;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity //Аннотацией Entity нам необходимо пометить объект, который мы хотим хранить в базе данных.
public class Word {
    @PrimaryKey  (autoGenerate = true) //Аннотацией PrimaryKey мы помечаем поле, которое будет ключом в таблице.
    public int id;

    @ColumnInfo(name = "Слово")
    public String original_word;
    @ColumnInfo(name = "Перевод")
    public String translate_word;

    public Word(String original_word, String translate_word){

        this.original_word=original_word;
        this.translate_word = translate_word;
    }

    public String getOriginal_word() {
        return this.original_word;
    }

    public void setOriginal_word(String original_word) {
        this.original_word = original_word;
    }

    public String getTranslate_word() {
        return this.translate_word;
    }

    public void setTranslate_word(String translate_word) {
        this.translate_word = translate_word;
    }


}
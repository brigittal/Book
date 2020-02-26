package com.example.book;

public class Word {

    private String wordo;
    private String wordtr;

    public Word(String wordo, String wordtr){

        this.wordo=wordo;
        this.wordtr = wordtr;
    }

    public String getWordo() {
        return this.wordo;
    }

    public void setWordo(String wordo) {
        this.wordo = wordo;
    }

    public String getWordtr() {
        return this.wordtr;
    }

    public void setWordtr(String wordtr) {
        this.wordtr = wordtr;
    }

}
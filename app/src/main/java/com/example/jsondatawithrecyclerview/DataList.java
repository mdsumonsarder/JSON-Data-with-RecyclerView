package com.example.jsondatawithrecyclerview;

public class DataList {

    String author;
    String name;

    public DataList(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public DataList() {


    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

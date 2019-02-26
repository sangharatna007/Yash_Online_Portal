package com.yash.Yash_Online_Portal.model;

public class Category {

    private int Id;

    private String title;

    public Category(int id, String title) {
        Id = id;
        this.title = title;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                '}';
    }
}

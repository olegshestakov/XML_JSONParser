package org.sourceit.entites;

public class Book {

    private String title;
    private String author;
    private String category;
    private int year;
    private int edition;
    private double price;

    public Book() {
    }

    public Book(String title, String author, String category, int year, int edition, double price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
        this.edition = edition;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

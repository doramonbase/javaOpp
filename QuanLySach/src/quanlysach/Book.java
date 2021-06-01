/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysach;

/**
 *
 * @author admin
 */
public class Book {
    private int id;
    private String title;
    private int status;
    private String publisher;
    private int price;
    private String author;
    private int discount;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String title, int status, String publisher, int price) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.publisher = publisher;
        this.price = price;
    }

    public Book(int id, String title, int status, String publisher, int price, String author) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.publisher = publisher;
        this.price = price;
        this.author = author;
    }

    public Book(int id, String title, int status, String publisher, int price, int discount) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.publisher = publisher;
        this.price = price;
        this.discount = discount;
    }

    public Book(int id, String title, int status, String publisher, int price, String author, int discount) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.publisher = publisher;
        this.price = price;
        this.author = author;
        this.discount = discount;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    
    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getDiscount() {
        return discount;
    }
    
    
    
    
    
}

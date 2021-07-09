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
public class Textbook extends Book {
    private String author;

    public Textbook() {
    }
    
    public Textbook(String author) {
        this.author = author;
    }

    public Textbook(int id, String title, int status, String publisher, int price, int type, String author) {
        super(id, title, status, publisher, price, type);
        this.author = author;
    }

    public Textbook(String title, int status, String publisher, int price, int type, String author) {
        super(title, status, publisher, price, type);
        this.author = author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getAuthor() {
        return author;
    }
    
    
    
    
}

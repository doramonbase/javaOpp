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

    public Textbook(int id, String title, int status, String publisher, int price, String author) {
        super(id, title, status, publisher, price);
        this.author = author;
    }
    
    
    
}
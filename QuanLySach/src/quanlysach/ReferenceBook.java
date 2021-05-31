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
public class ReferenceBook extends Book {
    private String author;
    private int discount;

    public ReferenceBook() {
    }
    
    public ReferenceBook(String author, int discount) {
        this.author = author;
        this.discount = discount;
    }

    public ReferenceBook(int id, String title, int status, String publisher, int price, String author, int discount) {
        super(id, title, status, publisher, price);
        this.author = author;
        this.discount = discount;
    }
    
    
}

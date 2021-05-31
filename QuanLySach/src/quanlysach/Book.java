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

    
    
    
}

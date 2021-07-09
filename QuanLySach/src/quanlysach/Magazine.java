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
public class Magazine extends Book {
    private int discount;

    public Magazine() {
    }

    public Magazine(int discount) {
        this.discount = discount;
    }

    public Magazine(int id, String title, int status, String publisher, int price, int type, int discount) {
        super(id, title, status, publisher, price, type);
        this.discount = discount;
    }

    public Magazine(String title, int status, String publisher, int price, int type, int discount) {
        super(title, status, publisher, price, type);
        this.discount = discount;
    }
    
    

    @Override
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int getDiscount() {
        return discount;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysach;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class BookView {
    
    public void printListOfMenu() {
        System.out.println("*******************************");
        System.out.println("Chọn hành động mà bạn muốn thực hiện");
        System.out.println("1.Xem danh sách");
        System.out.println("2.Tìm sách");
        System.out.println("3.Thêm sách");
        System.out.println("4.Sửa sách");
        System.out.println("5.Xóa sách");
        System.out.println("*******************************");
    }
    
    public int printChoice() {
        System.out.println("Mời nhập lựa chọn:");
        Scanner inp = new Scanner(System.in);
        int choice;
        do {
            while (!inp.hasNextInt()) {                
                System.out.println("Lựa chọn không khớp. Vui lòng nhập số!");
                inp.next();
            }
            choice = inp.nextInt();
            if(choice < 1 || choice > 5){
                System.out.println("Lựa chọn không khớp. Vui lòng nhập lại!");
            }                
        }while(choice < 1 || choice > 5);
        return choice;
    }
    
    public void printListOfBook(List<Book> list){
        list.forEach(books -> {
            System.out.format("%10s%10s%10s%10s%10s%10s%10s%10s%n",books.getId(),books.getTitle(),books.getStatus(),books.getPublisher(),books.getPrice(),books.getType(),books.getAuthor(),books.getDiscount());
        });
    }
    
    public void printBook(Book book){
        System.out.format("%10s%10s%10s%10s%10s%10s%10s%10s%n",book.getId(),book.getTitle(),book.getStatus(),book.getPublisher(),book.getPrice(),book.getType(),book.getAuthor(),book.getDiscount());
    }
    
    public String printInputBook(){
        System.out.println("Mời nhập tên sách:");
        Scanner inp = new Scanner(System.in);
        return inp.next();
    }
    
    public Book printInputInsertBook() {
        Book book = null;
        System.out.println("Mời nhập thông tin sách:");
        Scanner inp = new Scanner(System.in);
        System.out.println("Nhập tiêu đề sách:");
        String title = inp.next();
        System.out.println("Nhập trạng thái (0 hoặc 1):");
        int status;
        do {
            while (!inp.hasNextInt()) {                
                System.out.println("Trạng thái không khớp. Vui lòng nhập số!");
                inp.next();
            }
            status = inp.nextInt();
            if(status < 0 || status > 1){
                System.out.println("Trạng thái không khớp. Vui lòng nhập lại!");
            }                
        }while(status < 0 || status > 1);
        System.out.println("Nhập nhà xuất bản:");
        String publisher = inp.next();
        System.out.println("Nhập giá cả");
        int price;
        do {
            while (!inp.hasNextInt()) {                
                System.out.println("Giá cả không khớp. Vui lòng nhập lại!");
                inp.next();
            }
            price = inp.nextInt();
        }while(price <= 0);
        System.out.println("Nhập loại (từ 1 đến 3):");
        int type;
        do {
            while (!inp.hasNextInt()) {                
                System.out.println("Loại không khớp. Vui lòng nhập số!");
                inp.next();
            }
            type = inp.nextInt();
            if(type < 1 || type > 3){
                System.out.println("Loại không khớp. Vui lòng nhập lại!");
            }
        }while(type < 1 || type > 3);
        switch(type){
            case 1 -> {
                System.out.println("Nhập tác giả:");
                String author = inp.next();
                book = new Textbook(title, status, publisher, price, type, author);
            }
            case 2 -> {
                System.out.println("Nhập tác giả:");
                String author = inp.next();
                System.out.println("Nhập tỉ lệ giảm giá:");
                int discount;
                do {
                    while (!inp.hasNextInt()) {                
                        System.out.println("Tỉ lệ giảm giá không khớp. Vui lòng nhập lại!");
                        inp.next();
                    }
                    discount = inp.nextInt();
                }while(discount < 0);
                book = new ReferenceBook(title, status, publisher, price, type, author, discount);
            }
            case 3 -> {
                System.out.println("Nhập tỉ lệ giảm giá:");
                int discount;
                do {
                    while (!inp.hasNextInt()) {                
                        System.out.println("Tỉ lệ giảm giá không khớp. Vui lòng nhập lại!");
                        inp.next();
                    }
                    discount = inp.nextInt();
                }while(discount < 0);
                book = new Magazine(title, status, publisher, price, type, discount);
            }
        }
        return book;
    }
    
    public int printInputIdBook(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Nhập ID sách:");
        int id;
        do {
            while (!inp.hasNextInt()) {                
                System.out.println("ID không khớp. Vui lòng nhập số!");
                inp.next();
            }
            id = inp.nextInt();
            if(id <= 0){
                System.out.println("ID không khớp. Vui lòng nhập lại!");
            }                
        }while(id <= 0);
        return id;
    }
}

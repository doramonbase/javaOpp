/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysach;

import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class BookController {
    private final BookDAO model;
    private final BookView view;

    public BookController(BookDAO model, BookView view) {
        this.model = model;
        this.view = view;
    }
    
    public void inputHomeMenu() throws SQLException {
        view.printListOfMenu();
        int choice = view.printChoice();
        switch(choice) {
                case 1 -> {
                    displayListOfBook();
                }
                case 2 -> {
                    findBook();
                }
                case 3 -> {
                    insertBook();
                }
    
                default -> {
                    
                }
            }
    }
       
    public void displayListOfBook() throws SQLException {
        view.printListOfBook(model.getAllBooks());
        inputHomeMenu();
    }
    
    public void findBook() throws SQLException {
        String name = view.printInputBook();
        view.printListOfBook(model.getBookByName(name));
        inputHomeMenu();
    }
    
    public void insertBook() throws SQLException {
        Book book = view.printInputInsertBook();
        boolean rs = model.insertBook(book);
        if (rs) {
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Thêm thất bại!");
        }
        inputHomeMenu();
    }
    
    public void updateBook() throws SQLException {
        int idInput = view.printInputIdBook();
        Book book = model.getBookById(idInput);
        view.printBook(book);
        boolean rs = model.updateBook(book);
        if (rs) {
            System.out.println("Sửa thành công!");
        } else {
            System.out.println("Sửa thất bại!");
        }
        inputHomeMenu();
    }
    
    public void deleteBook() throws SQLException {
        int idInput = view.printInputIdBook();
        boolean rs = model.deleteBook(idInput);
         if (rs) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa thất bại!");
        }
        inputHomeMenu();
    }
}

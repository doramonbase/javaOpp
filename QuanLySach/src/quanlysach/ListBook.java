/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysach;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author admin
 */
public class ListBook {
    public List<Book> DisplayAllBooks() throws SQLException {
        List<Book> listBook = new ArrayList<>();
        JDBCConn.ConnMysql dbconn = new JDBCConn.ConnMysql("jdbc:mysql://localhost:3306/quan_ly_sach","root","");
        
        Connection conn = dbconn.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM books");
        
        while (rs.next()) {
            int type = rs.getInt("type");
            
            int id = rs.getInt("id");
            String title = rs.getString("title");
            int status = rs.getInt("status");
            String publisher = rs.getString("publisher");
            int price = rs.getInt("price");
            
            switch (type) {
                case 1 -> {
                        String author = rs.getString("author");
                        Textbook book = new Textbook(id, title ,status, publisher, price, author);
                        listBook.add(book);
                    }
                case 2 -> {
                        String author = rs.getString("author");
                        int discount = rs.getInt("discount");
                        ReferenceBook book = new ReferenceBook(id, title, status, publisher, price, author, discount);
                        listBook.add(book);
                    }
                case 3 -> {
                        int discount = rs.getInt("discount");
                        Magazine book = new Magazine(id, title, status, publisher, price, discount);
                        listBook.add(book);
                    }
                default -> {
                }
            }
        }
        return listBook;
    }
}

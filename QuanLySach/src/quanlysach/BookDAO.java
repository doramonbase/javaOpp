/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;

/**
 *
 * @author admin
 */
public class BookDAO {
    
    public List<Book> getAllBooks() throws SQLException {
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
                        Textbook book = new Textbook(id, title ,status, publisher, price, type, author);
                        listBook.add(book);
                    }
                case 2 -> {
                        String author = rs.getString("author");
                        int discount = rs.getInt("discount");
                        ReferenceBook book = new ReferenceBook(id, title, status, publisher, price, type, author, discount);
                        listBook.add(book);
                    }
                case 3 -> {
                        int discount = rs.getInt("discount");
                        Magazine book = new Magazine(id, title, status, publisher, price, type, discount);
                        listBook.add(book);
                    }
                default -> {
                }
            }
        }
        dbconn.disconnect();
        return listBook;
        
    }
    
    public List<Book> getBookByName(String titleInput) throws SQLException {
        List<Book> listBook = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ?";
        JDBCConn.ConnMysql dbconn = new JDBCConn.ConnMysql("jdbc:mysql://localhost:3306/quan_ly_sach","root","");
        
        Connection conn = dbconn.getConn();
        
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "%" + titleInput + "%");
            System.out.println(statement);
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {             
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    int status = rs.getInt("status");
                    String publisher = rs.getString("publisher");
                    int price = rs.getInt("price");
                    int type = rs.getInt("type");
                    switch (type) {
                        case 1 -> {
                                String author = rs.getString("author");
                                Textbook book = new Textbook(id, title ,status, publisher, price, type, author);
                                listBook.add(book);
                            }
                        case 2 -> {
                                String author = rs.getString("author");
                                int discount = rs.getInt("discount");
                                ReferenceBook book = new ReferenceBook(id, title, status, publisher, price, type, author, discount);  
                                listBook.add(book);
                            }
                        case 3 -> {
                                int discount = rs.getInt("discount");
                                Magazine book = new Magazine(id, title, status, publisher, price, type, discount);
                                listBook.add(book);
                            }
                        default -> {
                        }
                    }
                }
            }
            statement.close();
        }
        System.out.println(sql);
        dbconn.disconnect();
        return listBook;
    }
    
    public boolean insertBook(Book book) throws SQLException {
        String sql = "INSERT INTO books values (null, ?, ?, ?, ?, ?, ?, ?)";
        
        JDBCConn.ConnMysql dbconn = new JDBCConn.ConnMysql("jdbc:mysql://localhost:3306/quan_ly_sach","root","");
        
        Connection conn = dbconn.getConn();
        
        boolean rs;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getStatus());
            statement.setString(3, book.getPublisher());
            statement.setInt(4, book.getPrice());
            statement.setInt(5, book.getType());
            switch (book.getType()) {
                case 1 -> {
                    statement.setString(6, book.getAuthor());
                    statement.setNull(7, Types.NULL);
                }
                case 2 -> {
                    statement.setString(6, book.getAuthor());
                    statement.setInt(7, book.getDiscount());
                }
                case 3 -> {
                    statement.setString(6, book.getAuthor());
                    statement.setNull(7, Types.NULL);
                }
                default -> {
                    statement.setNull(6, Types.NULL);
                    statement.setNull(7, Types.NULL);
                }
            }
            System.out.println(statement);
            rs = statement.executeUpdate() > 0;
            
            statement.close();
        }
        
        dbconn.disconnect();
        return rs;
    }
    
    public Book getBookById(int idInput) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM books WHERE id = ?";
        JDBCConn.ConnMysql dbconn = new JDBCConn.ConnMysql("jdbc:mysql://localhost:3306/quan_ly_sach","root","");
        
        Connection conn = dbconn.getConn();
        
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idInput);
            System.out.println(statement);
            try (ResultSet rs = statement.executeQuery()) {
                if(rs.next()) {             
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    int status = rs.getInt("status");
                    String publisher = rs.getString("publisher");
                    int price = rs.getInt("price");
                    int type = rs.getInt("type");
                    switch (type) {
                        case 1 -> {
                                String author = rs.getString("author");
                                book = new Textbook(id, title ,status, publisher, price, type, author);
                                
                            }
                        case 2 -> {
                                String author = rs.getString("author");
                                int discount = rs.getInt("discount");
                                book = new ReferenceBook(id, title, status, publisher, price, type, author, discount);  
                                
                            }
                        case 3 -> {
                                int discount = rs.getInt("discount");
                                book = new Magazine(id, title, status, publisher, price, type, discount);
                                
                            }
                        default -> {
                        }
                    }
                }
            }
            statement.close();
        }
        System.out.println(sql);
        dbconn.disconnect();
        return book;
    }
    
    public boolean updateBook(Book book) throws SQLException {
        String sql = "UPDATE books SET title = ?, status = ?, publisher = ?, price = ?, type = ?, author = ?, discount = ? where id = ?";
        
        JDBCConn.ConnMysql dbconn = new JDBCConn.ConnMysql("jdbc:mysql://localhost:3306/quan_ly_sach","root","");
        
        Connection conn = dbconn.getConn();
        
        boolean rs;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(8, book.getId());
            
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getStatus());
            statement.setString(3, book.getPublisher());
            statement.setInt(4, book.getPrice());
            statement.setInt(5, book.getType());
            switch (book.getType()) {
                case 1 -> {
                    statement.setString(6, book.getAuthor());
                    statement.setNull(7, Types.NULL);
                }
                case 2 -> {
                    statement.setString(6, book.getAuthor());
                    statement.setInt(7, book.getDiscount());
                }
                case 3 -> {
                    statement.setString(6, book.getAuthor());
                    statement.setNull(7, Types.NULL);
                }
                default -> {
                    statement.setNull(6, Types.NULL);
                    statement.setNull(7, Types.NULL);
                }
            }
            
            rs = statement.executeUpdate() > 0;
            
            statement.close();
        }
        
        dbconn.disconnect();
        return rs;
    }
    
    public boolean deleteBook(int id) throws SQLException {
        String sql = "DELETE from books WHERE id = ?";
        
        JDBCConn.ConnMysql dbconn = new JDBCConn.ConnMysql("jdbc:mysql://localhost:3306/quan_ly_sach","root","");
        
        Connection conn = dbconn.getConn();
        
        boolean rs;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            
            rs = statement.executeUpdate() > 0;
            
            statement.close();
        }
        
        dbconn.disconnect();
        return rs;
    }
}

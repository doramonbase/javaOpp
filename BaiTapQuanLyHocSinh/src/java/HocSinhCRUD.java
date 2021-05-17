/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class HocSinhCRUD {
    String db_url = "jdbc:mysql://localhost/phpmyadmin/db_structure.php?server=1&db=quan_ly_hoc_sinh";
    String user_name = "root";
    String pass = "";
    Connection conn;
    
    void connect() throws SQLException{
        if (conn ==  null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = DriverManager.getConnection(db_url, user_name, pass);
        }
    }
    
    void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
    
    public boolean insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student values (null, ?, ?, ?, ?, ?)";
        connect();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, student.getName());
        statement.setString(2, student.getEmail());
        statement.setString(3, student.getAddress());
        statement.setFLoat(4, student.getMarkC());
        statement.setFloat(5, student.getMarkPHP());
        
        boolean rs = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rs;
    }

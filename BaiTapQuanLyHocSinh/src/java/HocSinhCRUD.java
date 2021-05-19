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
    String db_url;
    String user_name;
    String pass;
    Connection conn;

    public HocSinhCRUD(String db_url, String user_name, String pass) {
        this.db_url = db_url;
        this.user_name = user_name;
        this.pass = pass;
    }

    
    
    final void connect() throws SQLException{
        if (conn ==  null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = DriverManager.getConnection(db_url, user_name, pass);
        }
    }
    
    final void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
    
    public List<HocSinh> studentList() throws SQLException {
        List<HocSinh> listStudent;
        listStudent = new ArrayList<>();
        String sql = "SELECT * FROM student";
        connect();
        
        try (Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql)) {
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                float markC = rs.getFloat("markC");
                float markPHP = rs.getFloat("markPHP");
                
                HocSinh student = new HocSinh(id, name, email, address, markC, markPHP);
                listStudent.add((HocSinh)student);
            }
            rs.close();
            statement.close();
        }
        
        disconnect();
        return listStudent;
        
        
    }
    
    public boolean insertStudent(HocSinh student) throws SQLException {
        String sql = "INSERT INTO student values (null, ?, ?, ?, ?, ?)";
        connect();
        
        boolean rs;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getAddress());
            statement.setFloat(4, student.getMarkC());
            statement.setFloat(5, student.getMarkPHP());
            rs = statement.executeUpdate() > 0;
            
            statement.close();
        }
        
        disconnect();
        return rs;
    }
    
    public boolean updateStudent(HocSinh student) throws SQLException {
        String sql = "UPDATE student SET name = ?, email = ?, address = ?, markC = ?, markPHP = ? WHERE id = ?";
        connect();
        
        boolean rs;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getAddress());
            statement.setFloat(4, student.getMarkC());
            statement.setFloat(5, student.getMarkPHP());
            statement.setInt(6, student.getId());
            rs = statement.executeUpdate() > 0;
            
            statement.close();
        }
        disconnect();
        return rs;
    } 
    
    public boolean deleteStudent(HocSinh student) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";
        connect();
        
        boolean rs;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, student.getId());
            rs = statement.executeUpdate() > 0;
            
            statement.close();
        }
        disconnect();
        return rs;
    } 
    
    public HocSinh findStudent(int id) throws SQLException {
        HocSinh student = null;
        String sql = "SELECT * FROM student WHERE id = ?";
        
        connect();
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if(rs.next()) {
                    int idStudent = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    float markC = rs.getFloat("markC");
                    float markPHP = rs.getFloat("markPHP");
                    
                    student = new HocSinh(idStudent, name, email, address, markC, markPHP);
                    
                }
            }
            statement.close();
        }
        return student;
    }
}
    

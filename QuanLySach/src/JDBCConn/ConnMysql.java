/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCConn;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author admin
 */
public class ConnMysql {
    private final String url;
    private final String userName;
    private final String pw;

    public ConnMysql(String url, String userName, String pw) {
        this.url = url;
        this.userName = userName;
        this.pw = pw;
    }
    
    public Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, userName, pw);
    }
}

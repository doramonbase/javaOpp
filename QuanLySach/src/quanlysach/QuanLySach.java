/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysach;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class QuanLySach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ListBook getList = new ListBook();
            
            List<Book> list = getList.DisplayAllBooks();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
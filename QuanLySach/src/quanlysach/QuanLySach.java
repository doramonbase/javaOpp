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
public class QuanLySach {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BookDAO model = new BookDAO();
        BookView view = new BookView();
        
        BookController controller = new BookController(model,view);
        
        try{
            controller.inputHomeMenu();
        }catch(SQLException ex){
            System.out.println("Đã có lỗi xảy ra");
        }
        
    }
    
}

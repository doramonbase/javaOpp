/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecustomer;


import java.util.List;


/**
 *
 * @author admin
 */
public class ManageCustomer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Customer getList = new Customer();
            
            List<Customer> list = getList.scanCustomer();
            
            list.forEach(khach -> {
                System.out.format("%10s%10s%10s%10s%10s%10s%n",khach.getFullName(),khach.getAddress(),khach.getPhone(),khach.getAmount(),khach.getDiscount(),khach.getTax());
            });
            
            System.out.println(getList.CaculateTheAmount());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}

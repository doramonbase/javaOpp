/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Customer {
    private String fullName;
    private String address;
    private String phone;
    private int amount;
    private int discount;
    private int tax;

    public Customer() {
    }

    public Customer(String fullName, String address, String phone, int amount, int discount, int tax) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.amount = amount;
        this.discount = discount;
        this.tax = tax;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAmount() {
        return amount;
    }

    public int getDiscount() {
        return discount;
    }

    public int getTax() {
        return tax;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }
    
    
    Scanner customer = new Scanner(System.in);
    List<Customer> listCustomer = new ArrayList<>();
    public List<Customer> scanCustomer() {
        
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Nhap thong tin khach hang thu "+ (i+1) +":");
            System.out.println("Nhap ten:");
            String ten = customer.next();
            System.out.println("Nhap dia chi:");
            String diaChi = customer.next();
            System.out.println("Nhap so dien thoai:");
            String sdt = customer.next();
            System.out.println("Nhap tong tien:");
            int tongTien = customer.nextInt();
            System.out.println("Nhap giam gia:");
            int giamGia = customer.nextInt();
            System.out.println("Nhap thue:");
            int thue = customer.nextInt();
            
            Customer khachHang = new Customer(ten, diaChi, sdt, tongTien, giamGia, thue);
            this.listCustomer.add(khachHang);
        }
        return this.listCustomer;
    }
    
    public float CaculateTheAmount() {
        float tong = 0.0f;
        for (Customer khach : this.listCustomer) {
            tong = tong + khach.getAmount() - (khach.getAmount() * (khach.getDiscount() + khach.getTax()) /100);
        }
        return tong;
    }
}

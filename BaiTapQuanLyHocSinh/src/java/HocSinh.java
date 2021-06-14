/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class HocSinh {
    int id;
    String name;
    String email;
    String address;
    float markC;
    float markPHP;

    public HocSinh() {
    }
    
    public HocSinh(int id) {
        this.id = id;
    }

    public HocSinh(int id, String name, String email, String address, float markC, float markPHP) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.markC = markC;
        this.markPHP = markPHP;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMarkC() {
        return markC;
    }

    public void setMarkC(float markC) {
        this.markC = markC;
    }

    public float getMarkPHP() {
        return markPHP;
    }

    public void setMarkPHP(float markPHP) {
        this.markPHP = markPHP;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg23.pkg4;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Bai5 {
    public static void main(String[] args) {
        Input input = new Input();
        int[] canh = input.scanCanh();
        Triagle triagle = new Triagle(canh);
        triagle.CaculateSurface();
        Rectangle rectangle = new Rectangle(canh);
        rectangle.CaculateSurface();
    }
}
abstract class Shape {
    abstract int CaculateSurface();
}
class Triagle extends Shape {
    int[] canh;
    public Triagle (int[] canh) {
        this.canh = canh;
    }
    
    int CaculateSurface() {
        int surfaceTriagle = (canh[0] * canh[1])/2;
        return surfaceTriagle; 
    }

    
} 
class Rectangle extends Shape {
    int[] canh;
    public Rectangle (int[] canh) {
        this.canh = canh;
    }
    
    int CaculateSurface() {
        int surfaceRectangle = canh[0] * canh[1];
        return surfaceRectangle; 
    }

    
} 
class Input {
    Scanner scanCanh = new Scanner(System.in);
    public int[] scanCanh() {
        int[] canh = new int[2];
        
        System.out.println("Nhap x va y:");
        canh[0] = scanCanh.nextInt();
        canh[1] = scanCanh.nextInt();
        return canh;
    }
}
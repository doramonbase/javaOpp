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
public class salarySort {
    public static void main(String[] args) {
        scan scan = new scan();
        Object[][] workerInfor = scan.scanWorker();
        sort sort = new sort(workerInfor);
        sort.sortSalary();
    }
}
class scan {
    Scanner worker = new Scanner(System.in);
    
    public Object[][] scanWorker() {
        Object[][] workers = new Object[10][2];
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Nhap ten va luong của thanh vien thu "+ (i+1) +":");
            workers[i][0] = worker.next();
            workers[i][1] = worker.nextInt();
    
        }
        return workers;
    }
}
class sort {
    Object[][] workers;
    
    public sort(Object[][] workers){
        this.workers = workers;
    }
    int agent1;
    String agent2;
    public void sortSalary(){
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if((int)this.workers[j-1][1] < (int)this.workers[j][1]) {
                    agent1 = (int)this.workers[j-1][1];
                    this.workers[j-1][1] = this.workers[j][1];
                    this.workers[j][1] = agent1;
                    
                    agent2 = (String)this.workers[j-1][0];
                    this.workers[j-1][0] = this.workers[j][0];
                    this.workers[j][0] = agent2;
                    
                } 
            }
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.print( (i+1) + ". Ten: " +this.workers[i][0] + "--Luong:" + this.workers[i][1] + "\n");
        }
    }
}

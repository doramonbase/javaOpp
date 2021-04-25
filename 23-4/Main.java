/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg23.pkg4;

/**
 *
 * @author admin
 */

class school {
    String name;
    public void display(){
        name = "School";
        System.out.print(name + " ");
    }
}
class classes extends school{
    String indentify;
    public void displayClass() {
        super.display();
        indentify = "Class";
        System.out.print(indentify + " ");
    }
}
class teacher extends classes {
    String teacher;
    public void displayTeacher() {
        super.displayClass();
        teacher = "Teacher";
        System.out.print(teacher + " ");
    }
}
class student extends classes {
    String student;
    public void displayStudent() {
        super.displayClass();
        student = "Student";
        System.out.print(student + " ");
    }
}
class courses extends teacher {
    String courses;
    int countClass;
    int countEx;
    public void displayCourses() {
        super.displayTeacher();
        courses = "Course";
        countClass = 3;
        countEx = 4;
        System.out.print(courses + " " + countClass + " " + countEx + "\n");
    }
}


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        classes a = new classes();
        a.displayClass();
        System.out.println("");
        teacher b = new teacher();
        b.displayTeacher();
        System.out.println("");
        student c = new student();
        c.displayStudent();
        System.out.println("");
        courses d = new courses();
        d.displayCourses();
        
    }
    
}

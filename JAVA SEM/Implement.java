import java.util.Scanner;
class Student{
    private int rollno;
    private String name;
    private int mathmarks;
    private int phymarks;
    private int chemmarks;
    
public void getrequireddetails(){
    Scanner s=new Scanner(System.in);
    System.out.println("Enter Roll number: ");
    rollno=s.nextInt();
    s.nextLine();
    System.out.println("Enter name: ");
    name=s.nextLine();
    System.out.println("Enter math marks: ");
    mathmarks=s.nextInt();
    System.out.println("Enter physics marks: ");
    phymarks=s.nextInt();
    System.out.println("Enter chemistry marks: ");
    chemmarks=s.nextInt();
}
public void displayaverage(){
    double result=(mathmarks+phymarks+chemmarks)/3.0;
    System.out.println("Average marks of "+name+" is : "+result);
}
}
public class Implement{
    public static void main(String[] args){
        Student student=new Student();
        student.getrequireddetails();
        student.displayaverage();
    }
}
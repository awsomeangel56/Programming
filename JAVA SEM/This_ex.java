class Employee{
    String name;
    int age;

public Employee(String name,int age){
    this.name=name;
    this.age=age;
    }
public void displaydetails(){
    System.out.println("Name: "+this.name);
    System.out.println("Age: "+this.age);
    }
}
public class This_ex{
    public static void main(String[] args){
        Employee emp1=new Employee("Mohammed Bilal",20);
        emp1.displaydetails();
    }
}

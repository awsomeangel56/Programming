import java.io.*;
class Person implements Serializable{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
}
public class serialize{
    public static void main(String[] args){
        Person person=new Person("Bilal",20);
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Person.ser"));
            oos.writeObject(person);
            System.out.print("Object serialized to Person.ser successfully !!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
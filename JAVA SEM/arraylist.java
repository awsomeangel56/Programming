import java.util.*;
public class arraylist{
    public static void main(String[] args){
    ArrayList<String> list=new ArrayList<>();
    list.add("Apple");
    list.add("Banana");
    list.add("Cherry");
    list.add("Mango");
    System.out.println("Array List: "+list);    
    System.out.println("Element at index 1: "+list.get(3));   
    list.remove("Banana");
    System.out.println("List after removal: "+list); 
    System.out.println("Iterating through the list: ");
    for(String item:list){
        System.out.println(item);
        }
    }
}
class Animal{
    void eat(){
        System.out.println("This animal eats food !!");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("Dog barks");
    }
}
class Cat extends Animal{
    void meow(){
        System.out.println("Cat meows");
    }
}
public class inheritance{
    public static void main(String[] args) {
    Dog dog=new Dog();
    Cat cat=new Cat();
    dog.eat();
    dog.bark();
    cat.eat();
    cat.meow();
    }
}
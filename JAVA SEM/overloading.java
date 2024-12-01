class Addition{
    public int add(int a, int b){
        return a+b;
    }
    public int add(int a,int b,int c){
        return a+b+c;
    }
}
public class overloading{
    public static void main(String[] args){
        Addition result=new Addition();
        System.out.println("Sum of 2 and 3: "+result.add(2,3));
        System.out.println("Sum of 5, 10 and 22: "+result.add(5,10,22));
    }
}
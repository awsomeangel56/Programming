import java.util.*;
public class bcalc {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
        try{
        System.out.print("Enter first number: ");
        double num1=s.nextDouble();
        System.out.print("Enter second number: ");
        double num2=s.nextDouble();
        System.out.print("choose operation(+,-,*,/) to perform or press 'q' to quit: ");
        char operator=s.next().charAt(0);
        if(operator=='q'){
            break;
        }
        else{
            double result;
            switch(operator){
                case '+': result=num1+num2;
                break;
                case '-': result=num1-num2;
                break;
                case '*': result=num1*num2;
                break;
                case '/': if(num2==0){
                    throw new ArithmeticException("Cannot divide by zero");
                }
                else{
                    result=num1/num2;
                }
                break;
                default: throw new IllegalArgumentException("Invalid choice !!");
                }
                System.out.println("The result is: "+result);
            }
        }
        catch(InputMismatchException e){
            System.out.print("Error"+e);
        }
        catch(ArithmeticException e){
            System.out.print("Error"+e);
        }
        catch(IllegalArgumentException e){
            System.out.print("Error"+e);
        }
        }
    }
}

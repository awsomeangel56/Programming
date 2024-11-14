public class trycatch {
    public static void main(String[] args) {
        int[] numbers={1,2,3};
        try {
            int result=10/0;
        } catch (ArithmeticException e) {
            System.out.print("Arithmetic exception occured: "+e);
        }
        finally{
            System.out.print("This is the finally block for Arithmetic exception");
        }
        try {
            int number=numbers[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds exception occurred");
        }
        finally{
            System.out.print("This is the finally block for Array index out of bounds exception");
        }
    }
  
}

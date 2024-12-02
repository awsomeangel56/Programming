package reversepackage;
public class Reverse {
    public String reverseString(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }
}
import reversepackage.Reverse;
public class Reversing{
public static void main(String[] args){
    Reverse reverseobj=new Reverse();
    String str="Hello World";
    String reversedstr=reverseobj.reverseString(str);
    System.out.print(reversedstr);
}
}


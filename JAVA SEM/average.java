class AverageExceededException extends Exception{
public AverageExceededException(String message){
    super(message);
    }
}
public class average{
    public static void main(String[] args){
        try {
            if(args.length==0){
                System.out.print("Enter some command line arguments !!");
                return;
            }
            double sum=0;
            for(String arg:args){
                sum+=Double.parseDouble(arg);
            }
            double average=sum/args.length;
            if(average>100){
                throw new AverageExceededException("Average exceeded 100: "+average);
            }
            System.out.print("Average is: "+average);
            
        } catch(NumberFormatException e){
            System.out.print("Enter some valid numbers !!");
        }
        catch(AverageExceededException e){
            System.out.print(e);
        }
    }
}

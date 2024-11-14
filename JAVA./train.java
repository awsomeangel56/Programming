import java.util.*;
abstract class Compartment{
	protected int available;
	public Compartment(int available){
		this.available=available;
	}
	public abstract void notice();
	public void bookTicket(int seats){
		if (seats <= available){
			System.out.println(seats + " booked successfully.");
			available-=seats;
		}
		else{
			System.out.println("Not enough seats available");
		}
	}
}
class FirstClass extends Compartment{
	public FirstClass(int available){
		super(available);
	}
	public void notice(){
		System.out.println("First class compartment: " + available + " seats are available.\n");
	}
}
class GeneralClass extends Compartment{
	public GeneralClass(int available){
		super(available);
	}
	public void notice(){
		System.out.println("General class compartment: " + available + " seats are available.\n");
	}
}

public class train{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		FirstClass firstClass = new FirstClass(50);
		GeneralClass generalClass = new GeneralClass(100);
		firstClass.notice();
		generalClass.notice();
		System.out.println("Enter the ticket count to be booked in First Class: ");
		int firstClassTicket=sc.nextInt();
		firstClass.bookTicket(firstClassTicket);
		System.out.println("Enter the ticket count to be booked in General Class: ");
		int generalClassTicket=sc.nextInt();
		generalClass.bookTicket(generalClassTicket);
		firstClass.notice();
		generalClass.notice();		
	}
}

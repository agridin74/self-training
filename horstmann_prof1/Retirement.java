import java.util.*;
public class Retirement{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("==??? ");
		double goal = in.nextDouble();
		System.out.print("---???? ");
		double payment = in.nextDouble();
		System.out.print("---%: ");
		double interestRate = in.nextDouble();

		double balance = 0;
		int years = 0;
		while(balance < goal){
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			years++;
		}
		System.out.println("==>>> "+years );
	}
}

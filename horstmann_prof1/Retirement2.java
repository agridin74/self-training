import java.util.*;

public class Retirement2 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("==>>> ");
		double payment = in.nextDouble();
		System.out.print("% : ");
		double interestRate = in.nextDouble();

		double balance =0;
		int year =0;

		String input;
		do{
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			year++;

			System.out.printf("---- %d --- %,.2f%n",year, balance);
			System.out.print("(Y/N)");
			input = in.next();
		}while(input.equals("N"));
	}
}

import java.util.*;
public class InputTest{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("==>>>");
		String name = in.nextLine();
		System.out.print("=int=>");
		int age = in.nextInt();
		System.out.println("- "+ name + " - "+ (age+1));
	}
}

import java.util.*;
class ArrayDequeDemo {
	public static void main(String args[]){
		ArrayDeque<String> ad = new ArrayDeque<>();
		ad.push("A");
		ad.push("B");
		ad.push("C");
		ad.push("D");
		ad.push("E");
		ad.push("F");
		System.out.print(" -> ");
		while(ad.peek() != null)
			System.out.print(ad.pop() + " ");

		System.out.println();
	}
}

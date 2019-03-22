import java.util.*;

class ForEachDemo {
	public static void main(String args[]) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);

		System.out.print(" => ");
		for(int i : al){
			System.out.print(i + " ");
		}
		System.out.println();
		int sum = 0;
		for(int i : al)
				  sum += i;

		System.out.println(sum);
	}
}

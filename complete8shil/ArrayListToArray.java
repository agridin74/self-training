import java.util.*;
class ArrayListToArray {
	public static void main(String args[]) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);

		System.out.println(" => "+ al);
		Integer i1[]=new Integer[al.size()];
		i1 = al.toArray(i1);
		int sum = 0;
		for(int i : i1) {
			sum +=i;
		}
		System.out.println("sum: "+ sum);
	
	}
}

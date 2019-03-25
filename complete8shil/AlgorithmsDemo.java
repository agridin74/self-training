import java.util.*;
class AlgorithmsDemo {
	public static void main(String args[]) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(-3);
		ll.add(30);
		ll.add(-30);
		ll.add(3);

		Comparator<Integer> r = Collections.reverseOrder();
		Collections.sort(ll, r);
		System.out.print("sort reverse : ");
		for(int i : ll)
				  System.out.print(i + " ");
		System.out.println();
		Collections.shuffle(ll);
		System.out.print("=> ");
		for(int i : ll)
				  System.out.print(i+ " ");
		System.out.println();
		System.out.println("min: "+Collections.min(ll));
		System.out.println("max: "+Collections.max(ll));
	}
}


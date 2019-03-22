
import java.util.*;

class SpliteratorDemo {
	public static void main(String args[]) {
		ArrayList<Double> al = new ArrayList<>();

		al.add(1.0);
		al.add(2.0);
		al.add(3.0);
		al.add(4.0);
		al.add(5.0);
		System.out.print(" => \n");
		Spliterator<Double> sp =  al.spliterator();
		while(sp.tryAdvance((n) -> System.out.println(n)));
		System.out.println();
		sp = al.spliterator();
		ArrayList<Double> sq =  new ArrayList<>();
		while(sp.tryAdvance((n) -> sq.add(Math.sqrt(n))));
		System.out.print(" => \n");
		sp = sq.spliterator();
		sp.forEachRemaining((n) -> System.out.println(n));
		System.out.println();
	}
}

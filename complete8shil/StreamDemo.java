import java.util.*;
import java.util.stream.*;

class StreamDemo {
	public static void main(String[] args){
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(7);
		myList.add(18);
		myList.add(10);
		myList.add(24);
		myList.add(17);
		myList.add(5);
		System.out.println("=>>" + myList);
		Stream<Integer> myStream = myList.stream();
		Optional<Integer> minVal = myStream.min(Integer::compare);
		if(minVal.isPresent()) System.out.println("min: " + minVal.get());
		myStream = myList.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare);
		if(maxVal.isPresent()) System.out.println("max: " + maxVal.get());

		Stream<Integer> sortedStream = myList.stream().sorted();
		System.out.print("sort: ");
		sortedStream.forEach((n) -> System.out.print(n + " "));
		System.out.println();

		Stream<Integer> oddVals =
				  myList.stream().sorted().filter((n) -> (n % 2) == 1);
		System.out.print("==>> ");
		oddVals.forEach((n) -> System.out.print(n + " "));
		System.out.println();

		oddVals = myList.stream().filter((n) -> (n % 2) == 1)
				  .filter((n) -> n>5);
		System.out.print("==>>> ");
		oddVals.forEach((n) -> System.out.print(n + " "));
		System.out.println();
	}
}

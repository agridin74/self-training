import java.util.*;

class CompLastNames implements Comparator<String> {
	public int compare(String aStr, String bStr){
		int i, j;

		i = aStr.lastIndexOf(' ');
		j = bStr.lastIndexOf(' ');
		return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
	}
}

class CompThenByFirstName implements Comparator<String> {
	public int compare(String aStr, String bStr) {
		int i, j;
		return aStr.compareToIgnoreCase(bStr);
	}
}

class TreeMapDemo2A {
	public static void main (String args[]) {
		CompLastNames compLN = new CompLastNames();
		Comparator<String> compLastThenFirst = 
				  compLN.thenComparing(new CompThenByFirstName());
		TreeMap<String, Double> tm = 
				  new TreeMap<String, Double>(compLastThenFirst);
		tm.put("A B", new Double(1.1));
		tm.put("C D", new Double(2.2));
		tm.put("E F", new Double(3.3));
		tm.put("J H", new Double(4.4));
		tm.put("E A", new Double(5.5));

		Set<Map.Entry<String, Double>> set = tm.entrySet();
		for(Map.Entry<String, Double> me : set){
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();

		double bal = tm.get("A B");
		tm.put("A B", bal + 1000);
		System.out.println(tm.get("A B"));
	}
}

import java.util.*;

class TreeMapDemo {
	public static void main(String args[]){
		TreeMap<String, Double> tm = new TreeMap<String, Double>();
		tm.put("1", new Double(1.1));
		tm.put("2", new Double(2.2));
		tm.put("3", new Double(3.3));
		tm.put("4", new Double(4.4));
		tm.put("5", new Double(-5.5));

		Set<Map.Entry<String, Double>> set = tm.entrySet();

		for(Map.Entry<String, Double> me : set){
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		double sum = tm.get("4");
		tm.put("4", sum + 1000);
		System.out.println(tm.get("4"));
	}
}

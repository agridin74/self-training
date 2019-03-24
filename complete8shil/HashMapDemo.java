import java.util.*;
class HashMapDemo {
	public static void main (String args[]) {
		HashMap<String, Double> hm = new HashMap<String, Double>();
		hm.put("1", new Double(1.1));
		hm.put("2", new Double(2.2));
		hm.put("3", new Double(3.3));
		hm.put("4", new Double(4.4));
		hm.put("5", new Double(-5.5));

		Set<Map.Entry<String, Double>> set = hm.entrySet();
		for(Map.Entry<String, Double> me : set){
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		double bl = hm.get("3");
		hm.put("3", bl + 1000);
		System.out.println(" => "+hm.get("3"));

	}
}

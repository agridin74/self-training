import java.util.*;

class TComp implements Comparator<String> {
	public int compare(String aStr, String bStr){
		int i, j, k;
		i = aStr.lastIndexOf(' ');
		j = bStr.lastIndexOf(' ');
		k = aStr.substring(i).compareTo(bStr.substring(j));
		if(k==0)
				  return aStr.compareTo(bStr);
		else
				  return k;
	}
}

class TreeMapDemo2 {
	public static void main(String args[]) {
		TreeMap<String, Double> tm =
				  new TreeMap<String, Double>(new TComp());
		tm.put("1 2", new Double(1.1));
		tm.put("3 4", new Double(2.2));
		tm.put("5 6", new Double(3.3));
		tm.put("7 8", new Double(4.4));
		tm.put("A B", new Double(-5.5));

		Set<Map.Entry<String, Double>> set = tm.entrySet();

		for(Map.Entry<String, Double> me : set){
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		double bal = tm.get("1 2");
		tm.put("1 2", bal + 1000);
		System.out.println(tm.get("1 2"));
	}
}

import java.util.*;

class HTDemo2 {
	public static void main(String args[]){
		Hashtable<String, Double> balance=
			new Hashtable<String, Double>();

		String str;
		double bal;
		balance.put("A B", 1.1);
		balance.put("C D", 2.2);
		balance.put("E F", 3.3);
		balance.put("J H", 4.4);
		balance.put("K L", 5.5);

		Set<String> set = balance.keySet();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()){
			str = itr.next();
			System.out.println(str + ": " + balance.get(str));

		}
		System.out.println();
		bal = balance.get("A B");
		balance.put("A B", bal + 1000);
		System.out.println(balance.get("A B"));
	}
}

import java.util.*;

class HTDemo {
	public static void main(String args[]){
		Hashtable<String,Double> balance = 
				  new Hashtable<String, Double>();
		Enumeration<String> names;

		String str;
		double bal;

		balance.put("A B",1.1);
		balance.put("C D",2.2);
		balance.put("E F",3.3);
		balance.put("J H",4.4);
		balance.put("K L",5.5);

		names = balance.keys();

		while(names.hasMoreElements()){
			str = names.nextElement();
			System.out.println(str + ": "+ balance.get(str));

		}

		System.out.println();
		bal = balance.get("C D");
		balance.put("C D", bal + 1000);
		System.out.println(" =>>> " + balance.get("C D"));
	}
}

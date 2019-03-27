import java.util.*;
class PropDemo {
	public static void main(String args[]) {
		Properties prop = new Properties();
		prop.put("A","1");
		prop.put("B","2");
		prop.put("C","3");
		prop.put("D","4");
		prop.put("E","5");

		Set<?> st = prop.keySet();

		for(Object name : st)
			System.out.println("name- "+ name 
					+ prop.getProperty((String)name)+ ".");
		System.out.println();

		String str = prop.getProperty("X","not found");
		System.out.println(str);
	}
}

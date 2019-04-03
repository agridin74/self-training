import java.util.*;

class LRBDemo {
	public static void main(String args[]) {
		ResourceBundle rd = ResourceBundle.getBundle("SampleRB");
		System.out.println("Angl: ");
		System.out.println("str key Title: " + rd.getString("title"));
		System.out.println("str key StopText: " + rd.getString("StopText"));
		System.out.println("str key StartText: " 
							 + rd.getString("StartText"));
		rd = ResourceBundle.getBundle("SampleRB", Locale.GERMAN);
		System.out.println("\n German ");
		System.out.println("str key Title: "+ rd.getString("title"));
		System.out.println("str key StopText: " + rd.getString("StopText"));
		System.out.println("str key StartText: " +
							 rd.getString("StartText"));
	}
}

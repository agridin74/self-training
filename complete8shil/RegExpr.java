import java.util.regex.*;

class RegExpr {
	public static void main(String args[]){
		Pattern pat;
		Matcher mat;
		boolean found;

		pat = Pattern.compile("Java");
		mat = pat.matcher("Java");
		found = mat.matches();
		System.out.println("====");
		if(found) System.out.println("+++");
		else System.out.println("---");
		System.out.println();
		System.out.println("====");
		mat = pat.matcher("Java 8");
		found = mat.matches();
		if(found) System.out.println("++++");
		else System.out.println("---");
	}
}

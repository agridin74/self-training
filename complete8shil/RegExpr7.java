import java.util.regex.*;
class RegExpr7 {
	public static void main(String args[]){
		Pattern pat = Pattern.compile("[a-z]+");
		Matcher mat = pat.matcher("this is a test.");

		while(mat.find())
				  System.out.println(mat.group());
	}
}

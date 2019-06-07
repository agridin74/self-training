import java.util.regex.*;
class RegExpr2{
	public static void main(String args[]){
		Pattern pat = Pattern.compile("Java");
		Matcher mat = pat.matcher("Java 8");
		System.out.println("1.==>>");
		if(mat.find()) System.out.println("+++");
		else System.out.println("----");
	}
}

import java.util.*;
class CurDemo {
	public static void main(String args[]){
		Currency c;
		c = Currency.getInstance(Locale.US);
		System.out.println(c.getSymbol());
		System.out.println(c.getDefaultFractionDigits());
	}
}

import java.util.*;

class FormatDemo {
	public static void main(String[] args){
		Formatter fmt = new Formatter();
		fmt.format("== %S == %d %f","jhkjhk",10, 89.7);
		System.out.println(fmt);
		fmt.close();
	}
}

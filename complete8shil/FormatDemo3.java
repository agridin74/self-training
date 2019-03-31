import java.util.*;

class FormatDemo3 {
	public static void main(String[] args){
		Formatter fmt = new Formatter();
		fmt.format("dfsds %n fsdfdf %d%%",88);
		System.out.println(fmt);
		fmt.close();
	}
}

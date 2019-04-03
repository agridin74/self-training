
import java.util.*;
class FindInLineDemo {
	public static void main(String[] args){
		String instr = "Name: Tom Year: 28 ID: 77";
		Scanner conin = new Scanner(instr);

		conin.findInLine("Year:");
		if(conin.hasNext())
			 System.out.println(conin.next());
		else
			System.out.println("err");
		conin.close();		
	}
}

import java.util.*;
class AvgNums {
	public static void main(String args[]){
		Scanner conin = new Scanner(System.in);
		int count = 0;
		double sum = 0.0;

		System.out.println("=====>>>");
		while(conin.hasNext()){
			if(conin.hasNextDouble()){
				sum += conin.nextDouble();
				count++;
			}
			else {
				String str = conin.next();
				if(str.equals("quit")) break;
				else {
					System.out.println("error format");
					return;
				}
			}
		}

		conin.close();
		System.out.println(sum/count);
	}
}

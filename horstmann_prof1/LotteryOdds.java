import java.util.*;
public class LotteryOdds{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("==> ");
		int k = in.nextInt();
		System.out.print("==>>> ");
		int n = in.nextInt();

		int lotteryOdds =1;
		for(int i=1; i <= k ; i++)
				  lotteryOdds = lotteryOdds * (n - i +1)/i;
		System.out.println("=== "+lotteryOdds);
	}
}

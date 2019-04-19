import java.util.*;

public class generations{
	static long[] memo = new long[69]; 

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		Arrays.fill(memo,-1);
		for(int i = 0; i < t; i++){
			System.out.println(tribble(in.nextInt()));
		}
	}

	static long tribble(int n){
		if(memo[n] > -1)
			return memo[n];
		if(n < 2)
			return memo[n] = 1;
		if(n == 2)
			return memo[n] = 2;
		if(n == 3)
			return memo[n] = 4;

		return memo[n] = tribble(n-1) + tribble(n-2) + tribble(n-3) + tribble(n-4);
	}
}
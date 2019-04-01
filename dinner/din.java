import java.util.*;

public class din{
	static long[] memo = new long[101];

	public static void main(String[] args){

		//init memo and precompute cases up to 10
		Arrays.fill(memo,-1);
		memo[0] = 0;
		memo[1] = 0;
		memo[2] = 1;
		memo[3] = 0;
		memo[4] = 1;
		memo[5] = 1;
		memo[6] = 1;
		memo[7] = 2;
		memo[8] = 1;
		memo[9] = 3;
		memo[10] = 3;

		//read in numcases and run thru them
		Scanner in = new Scanner(System.in);
		int nC = in.nextInt();
		for(int i = 0 ; i < nC; i++){
			int n = in.nextInt();

			//recurse
			System.out.println("Dinner #" + (i+1) + ": " + go(n));
		}
	}

	static long go(int n){
		if(n < 2)
			return 0;

		if(memo[n] > -1)
			return memo[n];

		//basically fib
		return memo[n] = go(n-10) + go(n-5) + go(n-2);
	}
}
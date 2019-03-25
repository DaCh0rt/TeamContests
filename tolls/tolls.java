import java.util.*;

public class tolls{

	//global travel time and toll costs arrays, memo table
	static int[] tt;
	static int[][] tc;
	static int[][] memo;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and init case #
		int t = in.nextInt();
		int c = 1;
		for(int i = 0; i < t; i++){

			//read in num booths, init travel times, toll costs, and memo
			int n = in.nextInt();
			tt = new int[n-1];
			tc = new int[n][2];
			memo = new int[n][67];

			//read tt
			for(int j = 0; j < n-1; j++){
				tt[j] = in.nextInt();
			}

			//read tc, also init memo
			for(int j = 0; j < n; j++){
				tc[j][0] = in.nextInt();
				tc[j][1] = in.nextInt();
				Arrays.fill(memo[j],-1);
			}

			//try every possible start time and find best
			int res = (int)1e9;
			int min = res;
			for(int j = 0; j < 60; j++){
				res = go(0,j);
				// System.out.println("answer for time " + j + " is " + res + ".");
				if(res < min)
					min = res;
			}

			//print best
			System.out.println("Case #" + c + ": " + min);
			c++;
		}
	}

	static int go(int b, int t){

		//already been here
		if(memo[b][t]>-1)
			return memo[b][t];

		//wait time to next toll price and fetch both prices.
		int wait = (30-t%30);
		int aToll = tc[b][t%60<30?0:1];
		int wToll = tc[b][(t+wait)%60<30?0:1];

		//base case
		if(b >= tt.length)
			return memo[b][t] = Math.min(aToll, wait + wToll);

		//try immediately going vs waiting for the next toll change.
		return memo[b][t] = Math.min(aToll + go(b+1,(t+tt[b])%60), wait + wToll + go(b+1, (t + wait + tt[b])%60));
	}
}
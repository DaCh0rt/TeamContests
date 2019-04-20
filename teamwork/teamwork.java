import java.util.*;

public class teamwork{
	
	static long[][] memo = new long[1007][11007];

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in cases, run thru them
		int t = in.nextInt();
		for(int i = 0; i < t; i++){

			//read in num cows, max size of teams
			int n = in.nextInt();
			int k = in.nextInt();

			//init memo
			for(int j = 0; j < memo.length; j++){
				Arrays.fill(memo[j],-1);
			}

			//read in cows
			int[] list = new int[n];
			for(int j = 0; j < n; j++){
				list[j] = in.nextInt();
			}

			//recurse
			System.out.println(go(k,0,list));

		}
	}

	static long go(int k, int p, int[] list){

		//if already found ans
		if(memo[k][p]>-1){
			return memo[k][p];
		}

		//if we are going to run off the list
		if(p >= list.length)
			return memo[k][p] = 0;


		long max = 0;
		long max2 = 0;
		//try making a team of 1 to k cows
		for(int i = 1; i <= k; i++){
			
			//if not out of bounds
			if(p+i-1 < list.length)
				max2 = Math.max(max2,list[p+i-1]);

			//find out how many taken
			int taken = Math.min(i, list.length - p);

			//is making a team this big or one bigger better
			max = Math.max(max, taken*max2 + go(k,p+i,list));
		}

		//return best choice
		return memo[k][p] = max;
	}
}
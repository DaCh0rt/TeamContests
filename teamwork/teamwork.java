import java.util.*;

public class teamwork{
	
	static long[][] memo = new long[1007][11007];

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			int k = in.nextInt();

			for(int j = 0; j < memo.length; j++){
				Arrays.fill(memo[j],-1);
			}

			int[] list = new int[n];
			for(int j = 0; j < n; j++){
				list[j] = in.nextInt();
			}

			System.out.println(go(k,0,list));

		}
	}

	static long go(int k, int p, int[] list){

		if(memo[k][p]>-1){
			return memo[k][p];
		}

		if(p >= list.length)
			return memo[k][p] = 0;

		long max = 0;
		long max2 = 0;
		for(int i = 1; i <= k; i++){
			
			if(p+i-1 < list.length)
				max2 = Math.max(max2,list[p+i-1]);

			int taken = Math.min(i, list.length - p);
			max = Math.max(max, taken*max2 + go(k,p+i,list));
		}

		return memo[k][p] = max;
	}
}
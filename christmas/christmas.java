import java.util.*;

public class christmas{
	static long[] memo = new long[1000007];

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//init memo
		Arrays.fill(memo,-1);

		//run thru test cases, end with 0
		int n = in.nextInt();
		while(n!=0){

			//if already done, print and continue
			if(memo[n]>-1){
				System.out.println(memo[n]);
				n=in.nextInt();
				continue;
			}

			//calculate new number
			long ans=0;
			for(int i = 1; i <= n; i++){
				if(memo[i]>-1){
					ans += memo[i];
					continue;
				}

				//base case
				if(i <= 1){
					memo[i]=i;
					ans += i;
					continue;
				}

				//geometric series summation
				long num =(long)i*(i+1)/2;

				//definition
				memo[i] = num + memo[i-1];
				ans+=memo[i];				
			}

			//done calc new n, print sol.
			System.out.println(memo[n]);

			n=in.nextInt();
		}
	}
}
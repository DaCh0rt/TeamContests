import java.util.*;

public class lotto{
	static int n;
	static long[][] memo = new long[11][2007];

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		//read in first test case, cases end with 0 0
		n = in.nextInt();
		int m = in.nextInt();
		int c = 1;
		while(n!=0){

			//init memo
			for(int i = 0; i < memo.length; i++){
				Arrays.fill(memo[i],-1);
			}

			//recurse
			System.out.println("Case " + c + ": n = " + n + ", m = " + m + ", # lists = " + go(m,0));

			//prep next iter
			n = in.nextInt();
			m = in.nextInt();
			++c;
		}
	}

	static long go(int m, int l){

		//if already solved
		if(memo[l][m]>-1)
			return memo[l][m];

		//base case we made a valid perm
		if(l == n){
			return memo[l][m] = 1;
		}

		//perm remaining slots
		long ans=0;
		if(m>0){
			for(int i = m; i >= 1; i--){
				ans += go(i/2,l+1);
			}
		}

		return memo[l][m] = ans;
	}
}
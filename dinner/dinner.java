import java.util.*;

public class dinner{
	static int[] c = {2,5,10};
	static long[] fact = new long[51];

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int nC = in.nextInt();

		fact[0] = 1;
		for(int i = 1; i < fact.length; i++){
			fact[i] = fact[i-1] * i;
		}

		for(int i = 0; i < nC; i++){
			int n = in.nextInt();

			System.out.println("Dinner #" + (i+1) + ": " + go(n,0, new int[3], 0));
		}
	}

	static long go(int n, int d, int[] taken, int numTaken){
		if (n<0)
			return 0;
		else if (n==0){
			int max = 0;
			int idx = 0;
			for(int i = 0; i < taken.length; i++){
				if(taken[i] > max){
					max = taken[i];
					idx = i;
				}
			}
			int s = max;
			long numerator = mult(s,numTaken);
			for(int i = 0; i < taken.length; i++){
				if(i == idx)
					continue;

				numerator/=fact[taken[i]];
			}
			// System.out.println(numTaken + " takens " + taken[0] + " " + taken[1] + " " + taken[2] + "d: " + d + " numerator: " +  numerator);
			return numerator;
		}
		if (d>=c.length)
			return 0;

		long sum = 0;
		taken[d]+=1;
		sum += go(n-c[d],d,taken,numTaken+1);

		taken[d]-=1;
		sum += go(n, d+1, taken, numTaken);
		return sum;
	}

	static long mult(int s, int e){
		long ans = 1;
		for(int i = s+1; i <= e; i++){
			ans*=i;
		}
		return ans;
	}
}
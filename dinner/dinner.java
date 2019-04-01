import java.util.*;

public class dinner{
	static int[] c = {2,5,10};
	static long[] fact = new long[51];

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int nC = in.nextInt();

		//precompute some factorials
		fact[0] = 1;
		for(int i = 1; i < fact.length; i++){
			fact[i] = fact[i-1] * i;
		}

		//run thru cases
		for(int i = 0; i < nC; i++){
			int n = in.nextInt();

			//recurse and print answer, because of dividing out the largest factorial without calculating the number
			//our answer does not use numbers out of the bound for long and does not overflow
			System.out.println("Dinner #" + (i+1) + ": " + go(n,0, new int[3], 0));
		}
	}

	static long go(int n, int d, int[] taken, int numTaken){
		//overshot target
		if (n<0)
			return 0;

		//at target, we found a set of denominations that work
		else if (n==0){

			//find the most coins of a certain demonination taken
			int max = 0;
			int idx = 0;
			for(int i = 0; i < taken.length; i++){
				if(taken[i] > max){
					max = taken[i];
					idx = i;
				}
			}

			//"divide" the numerator with the biggest factorial in the denominator
			int s = max + 1;
			long numerator = mult(s,numTaken);

			//divide out the other 2 factorials
			for(int i = 0; i < taken.length; i++){
				if(i == idx)
					continue;

				numerator/=fact[taken[i]];
			}
			
			//done, # of ways to order the payments
			return numerator;
		}

		//ran out of coin denominations
		if (d>=c.length)
			return 0;

		//choice 1, take the current coin
		long sum = 0;
		taken[d]+=1;
		sum += go(n-c[d],d,taken,numTaken+1);

		//choice 2, move on to the next denom
		taken[d]-=1;
		sum += go(n, d+1, taken, numTaken);
		return sum;
	}

	static long mult(int s, int e){

		//multiplies numbers from s to e
		long ans = 1;
		for(int i = s; i <= e; i++){
			ans*=i;
		}
		return ans;
	}
}
import java.util.*;

public class safety{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			int total = 0;
			int[] scores = new int[n];
			double[] res = new double[n];

			for(int j = 0; j < n; j++){
				scores[j] = in.nextInt();
				total += scores[j];
			}

			for(int j = 0; j < n; j++)
			{
				double temp = (double)total;
				double tmp2 = (temp*2.0/(double)n) - (double)scores[j];
				res[j] = 100*(tmp2/total);
				// System.out.println("Temp2: " + tmp2);
			}

			for(int j = 0; j < n; j++)
			{

				System.out.printf("%.6f ", (res[j]<0?(double)0.0:res[j]));
			}
			System.out.println();
		}
	}
}
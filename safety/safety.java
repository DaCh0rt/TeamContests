import java.util.*;

public class safety{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			int[] jscore = new int[n];
			double[] ascore = new double[n];

			int x = 0;
			for(int j = 0; j < n; j++){
				jscore[j] = in.nextInt();
				x += jscore[j];
			}

			
			double high = 2.0*x/n;
			double low = 0;
			int remaining = 1000;
			while(remaining>0){

				double guess = (high+low)/2;
				// System.out.println("guess: " + guess + " high: " + high + " low: " + low);
				double sum = 0;
				double tmp = 0;
				Arrays.fill(ascore,0);
				for(int j = 0; j < n; j++){
					if((tmp = guess - jscore[j])>0){
						ascore[j] = tmp;
						sum += tmp;
					}
				}

				if(sum > x)
					high = guess;
				else if(sum < x)
					low = guess;
				else
					break;

				remaining--;
			}

			for(int j = 0; j < n; j++){
				System.out.printf("%f ",100*ascore[j]/x);
			}
			System.out.println();

		}
	}
}
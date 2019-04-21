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
			double sum = 0;
			int remaining = 250000;
			final double epsilon = 0;
			while(remaining>0){

				double guess = (high+low)/2;
				// System.out.println("guess: " + guess + " high: " + high + " low: " + low);
				sum = 0;
				double tmp = 0;
				for(int j = 0; j < n; j++){
					if((tmp = guess - jscore[j])>epsilon){
						ascore[j] = tmp;
						sum += tmp;
					} else {
						ascore[j] = 0;
					}
				}

				if(sum-x>epsilon)
					high = guess;
				else if(sum-x<epsilon)
					low = guess;
				else
					break;

				remaining--;
			}

			// System.out.print("Case #" + (i+1) + ": ");
			for(int j = 0; j < n; j++){
				System.out.printf("%f ",100*ascore[j]/sum);
			}
			System.out.println();

		}
	}
}
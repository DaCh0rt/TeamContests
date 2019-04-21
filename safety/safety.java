import java.util.*;

public class safety{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and run thru them
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int n = in.nextInt();

			//init arr to store judge and audience scores
			int[] jscore = new int[n];
			double[] ascore = new double[n];

			//get all judge scores and total
			int x = 0;
			for(int j = 0; j < n; j++){
				jscore[j] = in.nextInt();
				x += jscore[j];
			}

			//binary search for and arbitrary threshold
			double high = 2.0*x/n;
			double low = 0;
			double sum = 0;
			int remaining = 100000;
			final double epsilon = 0;

			//go until we call quits or we find our answer
			while(remaining>0){

				double guess = (high+low)/2;

				//give everyone audience points to get to the threshold if over or equal they get 0, keep track of audience total
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

				//if total is the same as judge that means everyone will be tied
				if(sum-x>epsilon)
					high = guess;
				else if(sum-x<epsilon)
					low = guess;
				else
					break;

				remaining--;
			}

			//done, print audience %s
			// System.out.print("Case #" + (i+1) + ": ");
			for(int j = 0; j < n; j++){
				System.out.printf("%f ",100*ascore[j]/sum);
			}
			System.out.println();

		}
	}
}
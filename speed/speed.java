import java.util.*;

public class speed{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int t = in.nextInt();

		int[] dists = new int[n];
		int[] mphs = new int[n];

		int min = (int)1e9;
		int total = 0;
		for(int i = 0; i < n; i++){
			dists[i] = in.nextInt();
			mphs[i] = in.nextInt();
			
			total+=dists[i];
			if(mphs[i]<min)
				min = mphs[i];
		}

		double high = 2e6;
		double low = -min;
		double guess = 0;
		int iter = 1000;
		while(iter>0){

			guess = (high+low)/2 - 1e-9;
			double hours = 0;
			for(int i = 0; i < n; i++){
				hours += dists[i]/(mphs[i]+guess);
			}

			double tmp = hours - t - 1e-9;
			if(tmp>0){
				low = guess;
			} else if(tmp<0){
				high = guess;
			} else {
				break;
			}

			iter--;
		}

		System.out.printf("%.7f",guess);
	}
}
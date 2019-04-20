import java.util.*;

public class sushi{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and run thru them
		int n = in.nextInt();
		for(int i = 0; i < n; i++){

			//read in num cars and car-time
			int c = in.nextInt();
			int[] ct = new int[c];
			for(int j = 0; j < c; j++){
				ct[j] = in.nextInt();
			}

			//read in people-times, negate so we can easily sort in reverse
			Integer[] pt = new Integer[4*c];
			for(int j = 0; j < c*4; j++){
				pt[j] = -1 * in.nextInt();
			}

			//sort cars, sort and fix people times
			Arrays.sort(ct);
			Arrays.sort(pt);
			for(int j = 0; j < pt.length; j++){
				pt[j]*=-1;
			}

			//put peeps in cars
			int max = 0;
			for(int j = 0; j < c; j++){
				int max2 = 0;

				//get the next 4 slowest people
				for(int k = 0; k < 4; k++){
					if(pt[j*4+k]>max2)
						max2=pt[j*4+k];
				}

				//put them in the next fastest car, time to eat is determined by the slowpoke
				int val = max2 + ct[j];
				if(val>max)
					max = val;
			}

			//dont, print sol
			System.out.println("Trip #" + (i+1) + ": " + max);
		}
	}
}
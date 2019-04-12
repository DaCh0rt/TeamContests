import java.util.*;

public class sushi{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		for(int i = 0; i < n; i++){
			int c = in.nextInt();
			int[] ct = new int[c];
			for(int j = 0; j < c; j++){
				ct[j] = in.nextInt();
			}

			Integer[] pt = new Integer[4*c];
			for(int j = 0; j < c*4; j++){
				pt[j] = -1 * in.nextInt();
			}

			Arrays.sort(ct);
			Arrays.sort(pt);
			for(int j = 0; j < pt.length; j++){
				pt[j]*=-1;
			}

			int max = 0;
			for(int j = 0; j < c; j++){
				int max2 = 0;

				for(int k = 0; k < 4; k++){
					if(pt[j*4+k]>max2)
						max2=pt[j*4+k];
				}

				int val = max2 + ct[j];
				if(val>max)
					max = val;
			}

			System.out.println("Trip #" + (i+1) + ": " + max);
		}
	}
}
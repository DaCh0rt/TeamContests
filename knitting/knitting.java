import java.util.*;

public class knitting{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		//read stitches in first row, rows in project, and rows in pattern
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		while(n!=0){

			//read in pattern
			int[] pat = new int[k];
			for(int i = 0; i < k; i++){
				pat[i] = in.nextInt();
			}

			//make each row
			int patiter = 0;
			int tot = n;
			for(int i = 1; i < m; i++){
				n += pat[patiter%k];
				patiter++;
				tot += n;
			}

			//done, print
			System.out.println(tot);

			//prep next
			n = in.nextInt();
			m = in.nextInt();
			k = in.nextInt();			
		}
	}
}
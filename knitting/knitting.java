import java.util.*;

public class knitting{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		while(n!=0){

			int[] pat = new int[k];
			for(int i = 0; i < k; i++){
				pat[i] = in.nextInt();
			}

			int patiter = 0;
			int tot = n;
			for(int i = 1; i < m; i++){
				n += pat[patiter%k];
				patiter++;
				tot += n;
			}

			System.out.println(tot);

			n = in.nextInt();
			m = in.nextInt();
			k = in.nextInt();			
		}
	}
}
import java.util.*;

public class balloons{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();

			boolean badx = false;
			boolean bady = false;
			for(int j = 0; j < n; j++){
				int tmp = in.nextInt();

				if(j == 0){
					if(tmp == x)
						badx = true;
				} else if(j == n-1){
					if (tmp == y)
						bady = true;
				}
			}

			if(badx && bady)
				System.out.println("BOTH");
			else if(badx)
				System.out.println("EASY");
			else if(bady)
				System.out.println("HARD");
			else
				System.out.println("OKAY");
		}

	}
}
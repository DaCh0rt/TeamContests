import java.util.*;

public class perfect{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases, run thru them
		int n = in.nextInt();
		for(int i = 0; i < n; i++){

			//read base and number
			int b = in.nextInt();
			int z = in.nextInt();

			//loop thru powers of base and see if match number
			int num = b;
			int pow = 1;
			boolean found = false;
			while(num < z){
				num = (int)Math.pow(b,pow);
				if(num == z){
					found = true;
					break;
				}

				pow++;
			}

			//print res
			System.out.println(found?"YES":"NO");
		}
	}
}
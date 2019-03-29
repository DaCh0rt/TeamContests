import java.util.*;

public class perfect{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		for(int i = 0; i < n; i++){
			int b = in.nextInt();
			int z = in.nextInt();

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

			System.out.println(found?"YES":"NO");
		}
	}
}
import java.util.*;

public class nametag{

	public static void main(String[] args){

		//read in num cases and run thru them
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++){

			//read in name and init pq
			PriorityQueue<String> pq = new PriorityQueue<String>();
			String s = in.next();

			//edge case
			if(s.length()<=1){
				System.out.println(s);
				continue;
			}

			//try all cuts of the name
			for(int j = 1; j <= s.length(); j++){
				pq.add(s.substring(j,s.length()) + s.substring(0,j));
			}

			//print best
			System.out.println(pq.poll());

		}
	}
}
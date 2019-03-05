import java.util.*;

public class relatives{
	static int oo = 100;

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		int p = in.nextInt();
		int r = in.nextInt();
		int netNum = 1;

		//run thru cases
		while(p!=0){

			if(r == 0){
				System.out.println("Network " + netNum + ": DISCONNECTED");
				netNum++;
				p = in.nextInt();
				r = in.nextInt();
				continue;
			}

			//init adjMat
			int[][] adjMat = new int[p][p];
			for(int i = 0; i < p; i++){
				for(int j = 0; j < p; j++){
					if(i == j)
						adjMat[i][j] = 0;
					else
						adjMat[i][j] = oo;
				}
			}
			
			//read and build graph
			int idx = 0;	
			HashMap<String,Integer> trans = new HashMap<String,Integer>();
			for(int i = 0; i < r; i++){
				String p1 = in.next();
				String p2 = in.next();

				if(!trans.containsKey(p1)){
					trans.put(p1,idx);
					idx++;
				}

				if(!trans.containsKey(p2)){
					trans.put(p2,idx);
					idx++;
				}

				adjMat[trans.get(p1)][trans.get(p2)] = 1;
				adjMat[trans.get(p2)][trans.get(p1)] = 1;

			}

			//run floyds
			for(int k = 0; k < p; k++){
				for(int i = 0; i < p; i++){
					for(int j = 0; j < p; j++){
						adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k]+adjMat[k][j]);
					}
				}
			}

			// printMat(G);

			//find max
			int max = 0;
			for(int i = 0; i < p; i++){
				for(int j = i + 1; j < p; j++){
					max = Math.max(max, adjMat[i][j]);
				}
			}

			//if had to use a bad edge
			if(max > p){
				System.out.println("Network " + netNum + ": DISCONNECTED");
			} else{
				System.out.println("Network " + netNum + ": " + max);
			}
			System.out.println();

			//set up next iter
			netNum++;
			p = in.nextInt();
			r = in.nextInt();
		}
	}

	static void printMat(int[][] m){
		for(int i = 0; i < m[0].length; i++){
			for(int j = 0; j < m.length; j++){
				System.out.printf("%3d ",m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
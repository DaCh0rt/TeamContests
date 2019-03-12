import java.util.*;

public class campout{
	public static int[][] cap;
	public static int n = 54;
	public static int source = 52;
	public static int sink = 53;
	final public static int oo = (int)1e9;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int nC = in.nextInt();
		for(int i = 0; i < nC; i++){
			cap = new int[n][n];//0-9 students, 10-51 shifts, 52 S, 53 T
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					cap[j][k] = 0;
				}
			}

			//run thru 10 students
			for(int j = 0; j < 10; j++){

				//each student can do max 20 shifts of 4 hrs each
				cap[source][j] = 20;

				//read in when busy in 168 hr week
				int c = in.nextInt();
				boolean[] hrs = new boolean[168];
				Arrays.fill(hrs,true);
				for(int k = 0; k < c; k++){
					int d = in.nextInt() - 1;
					int s = in.nextInt();
					int e = in.nextInt();
					int start = d*24 + s;
					int end = d*24 + e;

					//mark unavailable per block
					for(int x = start; x< end; x++){
						hrs[x]=false;
					}
				}

				//look at availabillity and see if they are open for whole blocks of 4 hrs
				for(int k = 0; k < 42; k++){
					boolean valid = true;
					for(int z = 0; z < 4; z++){
						if(hrs[k*4 + z] == false){
							valid = false;
						}
					}
					if(valid){//availible 4 hours, set as possible shift
						cap[j][10 + k] = 1;
					}
				}

				// System.out.print("Person #: " + (j+1) + "\t");
				// for(int k = 0; k < 42; k++){
				// 	System.out.print("(" + k + "," + cap[j][10+k] + ",[ ");
				// 	for(int z = 0; z < 4; z++){
				// 		System.out.print(hrs[k*4 + z] + " ");
				// 	}
				// 	System.out.print("])");
				// }
				// System.out.println();
			}

			//go thru each shift and look for 3 people
			for(int j = 0; j < 42; j++){
				cap[10 + j][sink] = 3;
			}

			boolean[] visited = new boolean[n];
			int flow = 0;

			while(true){
				Arrays.fill(visited,false);
				int res = dfs(source,visited,oo);

				if(res==0)
					break;

				flow+=res;
			}

			System.out.println("Case #" + (i+1) + ": " + (flow>=(42*3)?"YES":"NO") + "\n");

		}
	}

	public static int dfs(int v, boolean[] visited, int min){
		if(v==sink)
			return min;

		if(visited[v])
			return 0;

		visited[v] = true;
		int flow = 0;

		for(int i = 0; i < n; i++){
			// System.out.println("v,i: " + v + "," + i);
			if(cap[v][i] > 0){
				flow = dfs(i,visited,Math.min(cap[v][i],min));
			}

			if(flow > 0){
				cap[v][i] -= flow;
				cap[i][v] += flow;

				return flow;
			}
		}

		return 0;
	}
}
import java.util.*;

public class welcome{
	public static int[][] cap;
	public static int n = 54;
	public static int source = 52;
	public static int sink = 53;
	final public static int oo = (int)1e9;


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//run thru test cases, end at 0
		int nP = in.nextInt();
		while(nP!=0){

			//init graph
			cap = new int[n][n];//0-25 is first initials, 26-51 is last initials, 52 is source, 53 is sink

			//store initials of each person for graph
			char[][] initials = new char[nP][2];
			for(int i = 0; i < nP; i++){
				//read in first initial and set cap 1 from source to first initial
				initials[i][0] = in.next().charAt(0);
				cap[source][initials[i][0]-'A'] = 1;

				//read in second initial and set cap 1 from second to sink
				initials[i][1] = in.next().charAt(0);
				cap[initials[i][1] - 'A' + 26][sink] = 1;
			}

			//add bipartite edges
			for(int i = 0; i < nP; i++){
				cap[initials[i][0]-'A'][initials[i][1]-'A'+26] = 1;
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

			System.out.println(flow);


			nP = in.nextInt();
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
import java.util.*;

public class spidey{
	static int[][] adj;
	static int N;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and run thru them.
		int m = in.nextInt();
		for(int i = 0; i < m; i++){

			//read vertex and edge numbers
			int v = in.nextInt();
			int e = in.nextInt();

			//init adj and conn
			adj = new int[v][v];
			boolean[] conn = new boolean[v];
			Arrays.fill(conn,false);

			//assume good until proven otherwise
			boolean safe = true;
			for(int j = 0; j < e; j++){

				//read edges
				int a = in.nextInt();
				int b = in.nextInt();

				//if edges on opposite sides
				if(a%2 != b%2){
					conn[a] = true;
					conn[b] = true;
				} else{
					safe = false;
				}

				//build graph
				adj[a][b] = 1;
				adj[b][a] = 1;
			}

			//see if all vetexes are connected to opposite wall
			for(int j = 0; j < v; j++){
				if(!conn[j]){
					safe=false;
					break;
				}
			}


			//run dfs to see if graph is connected.
			N = v;
			if(!dfs())
				safe = false;

			System.out.println(safe?"Way to go, Spider-Man!":"It's the end of the world!");
			System.out.println();


		}

	}

	static boolean dfs(){
		boolean[] V = new boolean[N];
		int numComponents = 0;
		for(int i = 0; i<N; i++){
			if(!V[i]){
				++numComponents;
				DFS(i,V);
			}
		}

		if(numComponents>1)
			return false;
		else
			return true;
	}

	static void DFS(int at, boolean[] V){
		V[at] = true;
		for(int i = 0; i < N; i++){
			if(adj[at][i]>0 && !V[i]){
				DFS(i,V);
			}
		}
	}
}
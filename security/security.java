import java.util.*;

public class security{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in cases and run thru them
		int c = in.nextInt();
		for(int i = 0; i < c; i++){

			//read in num rooms and the height and width of building
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			point[] rooms = new point[n];

			//convert room numbers to points
			for(int j = 0; j < n; j++){
				int room = in.nextInt();

				rooms[j] = new point(room%100,room/100);
			}

			//init graph
			ArrayList<edge>[] graph = new ArrayList[n];
			for(int j = 0; j < n; j++){
				graph[j] = new ArrayList<edge>();
			}

			//calculate distances between each pair of points given definition
			for(int j = 0; j < n; j++){
				for(int k = j + 1; k < n; k++){

					int weight = a*Math.abs(rooms[j].x-rooms[k].x) + b*Math.abs(rooms[j].y-rooms[k].y);
					graph[j].add(new edge(j,k,weight));
					graph[k].add(new edge(k,j,weight));
				}
			}

			//prims and print
			System.out.println(mst(graph,0));
		}	
	}

	public static int mst(ArrayList[] graph, int v){
		int n = graph.length;
		boolean[] used = new boolean[n];
		used[v] = true;

		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		for(int i = 0; i < graph[v].size(); i++){
			pq.offer(((ArrayList<edge>)graph[v]).get(i));
		}

		int numEdges = 0, res = 0;

		while(pq.size()>0){
			edge next = pq.poll();
			if(used[next.v1]&&used[next.v2]) continue;

			if(!used[next.v1]){
				for(int i = 0; i < graph[next.v1].size(); i++)
					pq.offer(((ArrayList<edge>)graph[next.v1]).get(i));
				used[next.v1]=true;
			} else {
				for(int i = 0; i < graph[next.v2].size(); i++)
					pq.offer(((ArrayList<edge>)graph[next.v2]).get(i));
				used[next.v2]=true;
			}

			numEdges++;
			res += next.w;
			if(numEdges == n-1) break;
		}

		return numEdges == n-1? res:-1;
	}
}

class point{
	public int x;
	public int y;

	public point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class edge implements Comparable<edge>{
	public int v1;
	public int v2;
	public int w;

	public edge(int a, int b, int weight){
		v1 = a;
		v2 = b;
		w = weight;
	}

	public int compareTo(edge other){
		return this.w - other.w;
	}
}
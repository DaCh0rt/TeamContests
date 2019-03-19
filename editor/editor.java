import java.util.*;

public class editor{

	public static boolean[][] visited;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//run thru test cases
		int n = in.nextInt();
		for(int i = 0; i < n; i++){

			//parse input
			int f = in.nextInt();

			//fill line length array and find max, init visited array
			int[] ll = new int[f+1];
			int max = 0;
			for(int j = 1; j <= f; j++){
				ll[j] = in.nextInt();
				if(ll[j]>max)
					max=ll[j];
			}
			visited = new boolean[max+1][f+1];

			//read start and end
			int y = in.nextInt();
			int x = in.nextInt();
			Point start = new Point(x,y);

			y = in.nextInt();
			x = in.nextInt();
			Point end = new Point(x,y);

			//init bfs queue
			ArrayDeque<Point> q = new ArrayDeque<Point>();
			q.offer(start);

			//run bfs until we have our answer
			int iter = 0;
			boolean found = false;
			while(!q.isEmpty()){

				//run thru current layer
				int size = q.size();
				for(int j = 0; j < size; j++){

					//take next and check if it is the answer
					Point p = q.poll();
					if(p.x == end.x && p.y == end.y){
						System.out.println(iter);
						found = true;
						break;
					}

					//if already visited skip, otherwise mark visited
					if(visited[p.x][p.y])
						continue;
					else
						visited[p.x][p.y]=true;

					//find next state positions
					ArrayList<Point> toEnque = nextMoves(p,ll);

					//enque all next states
					for(int k = 0; k < toEnque.size(); k++){
						q.offer(toEnque.get(k));
					}
				}

				//break again out of the while when answer found
				if(found)
					break;

				iter++;
			}
		}
	}

	static ArrayList<Point> nextMoves(Point cur, int[] ll){
		ArrayList<Point> moves = new ArrayList<Point>();

		/* add all possilble moves */
		// System.out.println(cur.x + " " + cur.y);

		//left
		if(cur.x - 1 >= 0){//on line
			moves.add(new Point(cur.x-1,cur.y));
		} else if(cur.y-1 > 0){//inbounds
			moves.add(new Point(ll[cur.y-1],cur.y-1));
		}

		//right
		if(cur.x + 1 <= ll[cur.y]){//on line
			moves.add(new Point(cur.x+1,cur.y));
		} else if(cur.y+1 < ll.length){//inbounds
			moves.add(new Point(0,cur.y+1));
		}

		//up
		if(cur.y-1 > 0){//can go up
			if(cur.x <= ll[cur.y-1]){//pure up
				moves.add(new Point(cur.x,cur.y-1));
			} else{//up causes jump
				moves.add(new Point(ll[cur.y-1],cur.y-1));
			}
		}

		//down
		if(cur.y+1 < ll.length){//can go down
			if(cur.x <= ll[cur.y+1]){//pure down
				moves.add(new Point(cur.x,cur.y+1));
			} else{//down causes jump
				moves.add(new Point(ll[cur.y+1],cur.y+1));
			}
		}

		return moves;
	}
}

class Point{//just store and x and y for a point
	public int x;
	public int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
import java.util.*;

public class jumpman{
	static int r,c,j,x,y;
	static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
	static int[][] grid, treasure;
	static boolean[][] visited;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			r = in.nextInt();
			c = in.nextInt();
			j = in.nextInt();

			x = in.nextInt() - 1;
			y = in.nextInt() - 1;

			grid = new int[r][c];
			for(int j = 0; j < r; j++){
				for(int k = 0; k < c; k++){
					grid[j][k] = in.nextInt();
				}
			}

			treasure = new int[r][c];
			for(int j = 0; j < r; j++){
				for(int k = 0; k < c; k++){
					treasure[j][k] = in.nextInt();
				}
			}

			visited = new boolean[r][c];
			visited[x][y] = true;
			long ans = treasure[x][y] + dfs(x,y);
			System.out.println(ans);
		}
	}

	static boolean inBound(int j, int k){
		if(j < 0)
			return false;
		if(k < 0)
			return false;
		if(j >= r)
			return false;
		if(k >= c)
			return false;

		return true;
	}

	static long dfs(int px, int py){

		long ans = 0;

		for(int i = 0; i < 4; i++){
			int ax = px + dx[i];
			int ay = py + dy[i];

			if(inBound(ax,ay)){
				if(!visited[ax][ay]){
					ans += treasure[ax][ay];
					visited[ax][ay] = true;

					if(!(grid[ax][ay]-grid[px][py]>j)){
						ans += dfs(ax,ay);
					}
				}
			}
		}

		return ans;
	}
}
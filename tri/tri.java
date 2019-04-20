import java.util.*;

public class tri{

	static int[] ldx = {0,1}, ldy = {-1,-1};
	static int[] cdx = {-1,-1,0,1}, cdy = {0,-1,-1,-1};
	static int[] rdx = {-1,-1,0}, rdy = {0,-1,-1};

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int count = 1;
		while(n!=0){

			int[][] graph = new int[3][n];
			for(int i = 0; i < n; i++){
				graph[0][i] = in.nextInt();
				graph[1][i] = in.nextInt();
				graph[2][i] = in.nextInt();
			}

			int[][] shortest = new int[3][n];

			shortest[0][0] = (int)1e9; 
			shortest[1][0] = graph[1][0];
			shortest[2][0] = graph[2][0] + shortest[1][0];
			for(int i = 1; i < n; i++){
				for(int j = 0; j < 3; j++){
					int min = (int)1e9;
					if (j == 0){
						for(int k = 0; k < ldx.length; k++){
							int dx = j + ldx[k];
							int dy = i + ldy[k];

							if(shortest[dx][dy] < min)
								min = shortest[dx][dy];
						}
					} else if (j == 1){
						for(int k = 0; k < cdx.length; k++){
							int dx = j + cdx[k];
							int dy = i + cdy[k];

							if(shortest[dx][dy] < min)
								min = shortest[dx][dy];
						}
					} else {
						for(int k = 0; k < rdx.length; k++){
							int dx = j + rdx[k];
							int dy = i + rdy[k];

							if(shortest[dx][dy] < min)
								min = shortest[dx][dy];
						}
					}

					shortest[j][i] = graph[j][i] + min;
				}
			}

			// for(int i = 0; i < n; i++){
			// 	for(int j = 0; j < 3; j++){
			// 		System.out.print(shortest[j][i] + " ");
			// 	}System.out.println();
			// }

			System.out.println(count + ". " + shortest[1][n-1]);

			count++;
			n = in.nextInt();
		}
	}
}
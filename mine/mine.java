import java.util.*;

class mine{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int r = in.nextInt();
		int c = in.nextInt();
		while(r!=0){
			char[][] board = new char[r][c];
			for(int i = 0; i < r; i++){
				String s = in.next();
				for(int j = 0; j < c; j++){
					board[i][j] = s.charAt(j);
					// System.out.print(board[i][j]);
				}
				// System.out.println();
			}

			int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1}, dy = {1, 0, -1, 1, -1, 1, 0 , -1};
			for(int i = 0; i < r; i++){
				for(int j = 0; j < c; j++){
					if(board[i][j] == '*'){
						System.out.print(board[i][j]);
						continue;
					}

					int val = 0;
					for(int k = 0; k < dx.length; k++){
						int pi = i + dx[k];
						int pj = j + dy[k];
						if(pi >= 0 && pi < r && pj >= 0 && pj < c)
							if(board[pi][pj] == '*')
								val++;	
					}
					board[i][j] = (char)(val + '0');
					System.out.print(board[i][j]);
				}
				System.out.println();
			}

			r = in.nextInt();
			c = in.nextInt();
		}

	}
}
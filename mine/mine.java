import java.util.*;

class mine{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in rows and cols for the test case, testcases end with "0 0"
		int r = in.nextInt();
		int c = in.nextInt();
		while(r!=0){

			//init and read in board
			char[][] board = new char[r][c];
			for(int i = 0; i < r; i++){
				String s = in.next();
				for(int j = 0; j < c; j++){
					board[i][j] = s.charAt(j);
					// System.out.print(board[i][j]);
				}
				// System.out.println();
			}

			//go thru each spot in board
			int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1}, dy = {1, 0, -1, 1, -1, 1, 0 , -1};
			for(int i = 0; i < r; i++){
				for(int j = 0; j < c; j++){

					//mine, skip
					if(board[i][j] == '*'){
						System.out.print(board[i][j]);
						continue;
					}

					//not mine, count the mines around it
					int val = 0;
					for(int k = 0; k < dx.length; k++){
						int pi = i + dx[k];
						int pj = j + dy[k];
						if(pi >= 0 && pi < r && pj >= 0 && pj < c)
							if(board[pi][pj] == '*')
								val++;	
					}

					//replace board spot with num of mines adj.
					board[i][j] = (char)(val + '0');
					System.out.print(board[i][j]);
				}
				System.out.println();
			}

			//prep next case
			r = in.nextInt();
			c = in.nextInt();
		}

	}
}
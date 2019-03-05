import java.util.*;

public class extraset{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		int c = in.nextInt();
		for(int i = 0; i < c; i++){

			int k = in.nextInt();
			int n = in.nextInt();

			StringBuilder card = new StringBuilder(k);
			HashSet<String> cardset = new HashSet<String>();
			String[] cardArr = new String[n];
			for(int j = 0; j < n; j++){
				card.setLength(0);
				for(int x = 0; x < k; x++){
					card.append(in.nextInt());
				}
				cardset.add(card.toString());
				cardArr[j] = card.toString();
			}

			int total = 0;
			boolean[] used = new boolean[3];
			for(int x = 0; x < n; x++){
				for(int y = x + 1; y < n; y++){

					card.setLength(0);

					for(int z = 0; z < k; z++){
						Arrays.fill(used,false);

						int featx = cardArr[x].charAt(z) - '0';
						int featy = cardArr[y].charAt(z) - '0';

						used[featx] = true;
						used[featy] = true;

						if(featx != featy){
							for(int a = 0; a < used.length; a++){
								if(!used[a])
									card.append(a);
							}

						} else {
							card.append(cardArr[x].charAt(z));
						}
					}

					if(cardset.contains(card.toString())){
						total++;
					}
				}
			}

			total /= 3;
			System.out.println(total);


		}
	}
}
import java.util.*;

class perm
{
	static int[] original;

	static public void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();

		for(int i = 0; i < numCases; i++)
		{
			int caseNum = input.nextInt();
			String s = input.next();

			int[] original = new int[s.length()];
			for(int j = 0; j < s.length(); j++)
			{
				original[j] = s.charAt(j) - '0';
			}

			int[] idxs = new int[s.length()];
			Arrays.fill(idxs,-1);

			int max = -1;
			for(int j = original.length - 1; j >= 0; j--){
				for(for(int k = j; k >= 0; k--){
					if(original[j] > original[k]){
						idxs[j] = k;
						max = Math.max(k,max);
					}
				}
			}

			for(j = original.length; j <= 0; j--){
				if(idx[j] == max){
					int tmp = original[j];
					original[j] = original[idxs[j]];
					original[idxs[j]] = tmp;

					int[] a = new int[idxs[j]-original.length];
					for(int k = 0; k < a.length; k++){
						a[k] = original[original.length-k-1];
					}

					Arrays.sort(a);


					break;
				}
			}

		}
	}
}
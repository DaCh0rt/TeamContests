import java.util.*;

class perm
{

	static public void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();

		for(int i = 0; i < numCases; i++){

			//read in input and parse to int[]
			int caseNum = input.nextInt();
			String s = input.next();
			int[] arr = new int[s.length()];
			for(int j = 0; j < s.length(); j++)
			{
				arr[j] = s.charAt(j) - '0';
			}

			//find first num right to left greater than left
			int idx = -1;
			for(int j = arr.length - 1; j > 0; j--){
				if (arr[j] > arr[j-1]){
					idx = j-1;
					break;
				}
			}

			//not found, no solution
			if(idx == -1){
				System.out.println(caseNum + " BIGGEST");
				continue;
			}

			//copy part of array before idx, also find swap value and index
			int[] tmp = new int[arr.length-idx-1];
			int val = arr[idx];
			int min = (int)1e9;
			int swap = -1;
			for(int j = arr.length - 1; j > idx; j--){
				tmp[j-idx-1] = arr[j];
				if(arr[j] > val && arr[j] < min){
					swap = j-idx-1;
					min = arr[j];
				}
			}

			//swap values, and sort sublist
			arr[idx] = tmp[swap];
			tmp[swap] = val;
			Arrays.sort(tmp);

			//replace sublist with sorted one
			for(int j = arr.length - 1; j > idx; j--){
				arr[j] = tmp[j-idx-1];
			}

			//print out result
			System.out.print(caseNum + " ");
			for(int j = 0; j < arr.length; j++){
				System.out.print(arr[j]);
			}		
			System.out.println();
		}
	}
}
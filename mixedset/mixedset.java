import java.util.*;

public class mixedset{
	static boolean found;
	static int count;
	static int[] perm;
	static boolean[] used;
	static HashMap<Integer,Integer> difs;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and run thru them
		int c = in.nextInt();
		for(int i = 0; i < c; i++){

			//read n, numbers we can use up to n, s, the len of our perm, and k, the number of perm to print
			int n = in.nextInt();
			int s = in.nextInt();
			int k = in.nextInt();

			//recurse, keep track of the amount of perms and if we hit our count yet so we can break out after
			found = false;
			count = 0;
			perm = new int[s];
			used = new boolean[n];
			difs = new HashMap<Integer,Integer>();
			perm(0, k);
		}
	}

	static void perm(int k, int n){

		//we are done stop doing work
		if(found)
			return;

		//we found a perm
		if(k==perm.length){
			count++;

			//if this is the perm we want
			if(count == n){
				found = true;

				for(int i = 0; i < perm.length; i++){
					System.out.print(perm[i] + " ");
				}
				System.out.println();
			}
		}

		//try options for the slots
		for(int i = 0; i < used.length; i++){
			if(!used[i] && k < perm.length){

				//only permit numbers greater then the last
				if(k > 0 && i + 1 < perm[k-1])
					continue;

				//now check if adding the number violates those difs being unique
				boolean addable = true;
				for(int x = 0; x < k; x++){
					if(difs.containsKey((i+1)-perm[x])){
						addable = false;
						break;
					}
				}
				//if failed move on
				if(!addable)
					continue;

				//add the new difs to the hashmap
				int[] tmp = new int[k];
				for(int x = 0; x < k; x++){
					tmp[x] = (i+1)-perm[x];
					difs.put(tmp[x],0);
				}

				//permute
				used[i] = true;
				perm[k] = i + 1;
				perm(k+1,n);
				used[i] = false;

				//remove the new difs from the hashmap so we can try something else
				for(int x = 0; x < k; x++){
					difs.remove(tmp[x]);
				}
			}
		}
	}
}
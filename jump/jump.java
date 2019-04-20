import java.util.*;

public class jump
{
	public static int validCounter;

	public static void main(String[] args)
	{

		//init vars
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		int numBlocks;
		int blocks[];
		int maxUp;
		int maxDown;
		boolean used[];

		//run thru cases
		for(int i = 0; i < numCases; i++)
		{
			//read input and init
			numBlocks = input.nextInt();
			validCounter = 0;
			blocks = new int[numBlocks];
			used = new boolean[numBlocks];

			//read each block
			for(int j = 0; j < numBlocks; j++)
			{
				blocks[j] = input.nextInt();
			}

			//read params
			maxUp = input.nextInt();
			maxDown = input.nextInt();

			//perm and print
			printperms(blocks, new int[numBlocks], used, 0, maxUp, maxDown);
			System.out.println(validCounter);
		}
	}

	public static void printperms(int[] blocks, int[] perm, boolean[] used, int k, int maxUp, int maxDown)
	{
		int difference;
		boolean weBroke = false;

		//if we have filled out a perm
		if(k == perm.length)
		{
			//validate the perm
			for(int z = 0; z < perm.length -1; z++)
			{
				difference = perm[z] - perm[z+1];

				// System.out.println("perm z,z+1: " + perm[z] + "," +  perm[z+1] + "\tdiff: " + difference + "\tmaxup: " +  maxUp + "\tmaxdown: " +  maxDown + "\t" + weBroke);

				if(difference > 0 && difference > maxDown)
				{
					weBroke = true;
					break;
				}

				if(difference < 0 && Math.abs(difference) > maxUp)
				{
					weBroke = true;
					break;
				}
			}

			if(!weBroke)
				validCounter++;
		}

		//perm
		for(int i = 0; i < perm.length; i++)
		{
			if(!used[i])
			{
				used[i] = true;
				perm[k] = blocks[i];

				printperms(blocks, perm, used, k+1, maxUp, maxDown);

				used[i] = false;
			}
		}
	}
}

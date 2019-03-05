import java.util.*;

public class jump
{
	public static int validCounter;

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		int numBlocks;
		int blocks[];
		int maxUp;
		int maxDown;
		boolean used[];

		for(int i = 0; i < numCases; i++)
		{
			numBlocks = input.nextInt();
			validCounter = 0;
			blocks = new int[numBlocks];
			used = new boolean[numBlocks];

			for(int j = 0; j < numBlocks; j++)
			{
				blocks[j] = input.nextInt();
			}

			maxUp = input.nextInt();
			maxDown = input.nextInt();

			printperms(blocks, new int[numBlocks], used, 0, maxUp, maxDown);
			System.out.println(validCounter);
		}
	}

	public static void printperms(int[] blocks, int[] perm, boolean[] used, int k, int maxUp, int maxDown)
	{
		int difference;
		boolean weBroke = false;

		if(k == perm.length)
		{
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

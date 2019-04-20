import java.util.*;

public class framing
{
	public static void main(String[] args)
	{

		//init vars
		Scanner input = new Scanner(System.in);
		int numGroups = input.nextInt();
		int numPeople;
		int numFrames;
		double length;
		double width;
		double diagonal;
		double added;
		double total;
		double newTotal;
		double newLength;
		double newWidth;
		double answer;

		//run thru cases
		for(int i = 0; i < numGroups; i++)
		{
			//run thru people
			numPeople = input.nextInt();
			answer = 0;
			for(int j = 0; j < numPeople; j++)
			{
				//run thru frames
				numFrames = input.nextInt();
				for(int z = 0; z < numFrames; z++)
				{
					//read in dims
					length = input.nextDouble();
					width = input.nextDouble();
					diagonal = input.nextDouble();

					//find padding
					added = Math.sqrt(Math.pow(diagonal, 2) / 2);
					added *= 2;

					//find frame dims
					newLength = length + added;
					newWidth = width + added;

					//find both areas
					newTotal = newLength * newWidth;
					total = length * width;

					//sub out hole
					answer += newTotal - total;
				}

			}
			System.out.printf("Group #%d: %.2f cubic inches\n\n",(i+1),answer);
		}
	}
}
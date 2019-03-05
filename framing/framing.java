import java.util.*;

public class framing
{
	public static void main(String[] args)
	{

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
		for(int i = 0; i < numGroups; i++)
		{
			numPeople = input.nextInt();
			answer = 0;
			for(int j = 0; j < numPeople; j++)
			{
				numFrames = input.nextInt();

				for(int z = 0; z < numFrames; z++)
				{
					length = input.nextDouble();
					width = input.nextDouble();
					diagonal = input.nextDouble();

					added = Math.sqrt(Math.pow(diagonal, 2) / 2);
					added *= 2;

					newLength = length + added;
					newWidth = width + added;

					newTotal = newLength * newWidth;
					total = length * width;

					answer += newTotal - total;
				}

			}
			System.out.printf("Group #%d: %.2f cubic inches\n\n",(i+1),answer);
		}
	}
}
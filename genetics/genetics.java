import java.util.*;

public class genetics
{
	public static void main(String[] args)
	{
		//init vars
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		String original;
		String result = "";
		String multiple[];
		int total;
		int count;
		char temp;
		int tempTwo;
		String baseFour;

		//run thru cases
		for(int i = 0; i < numCases; i++)
		{
			//read in line
			original = input.next();
			total = 0;
			count = 0;
			tempTwo = 0;
			result = "";
			
			// Covert to base 4
			if(Character.isDigit(original.charAt(0)))
			{
				baseFour = Integer.toString(Integer.parseInt(original, 10), 4);

				for(int j = 0; j < baseFour.length(); j++)
				{
					if(baseFour.charAt(j) - '0' == 0)
						result += 'A';
					if(baseFour.charAt(j) - '0' == 1)
						result += 'C';
					if(baseFour.charAt(j) - '0' == 2)
						result += 'G';
					else if(baseFour.charAt(j) - '0' == 3)
						result += 'T';					
				}
				// covert base 4 to characters


			}
			// Convert to base 10
			else
			{
				multiple = new String[original.length()];

				for(int j = original.length() - 1; j >= 0; j--)
				{
					temp = original.charAt(j);
					
					if(temp == 'A')
						tempTwo = 0;
					else if(temp == 'C')
						tempTwo = 1;
					else if(temp == 'G')
						tempTwo = 2;
					else if(temp ==  'T')
						tempTwo = 3;

					total += tempTwo * Math.pow(4, count++);

					result = Integer.toString(total);
				}
			}

			//done,print ans
			System.out.println("Sequence #" + (i+1) + ": " + result);
		}
	}
}
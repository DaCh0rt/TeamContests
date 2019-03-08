import java.util.*;

public class burrito
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		int chickenTotal;
		int steakTotal;
		int numPeople;
		int chickenVal;
		int steakVal;

		for(int i = 0; i < numCases; i++)
		{
			chickenTotal = input.nextInt();
			steakTotal = input.nextInt();
			numPeople = input.nextInt();

			for(int j = 0; j < numPeople; j++)
			{
				//System.out.println("chickenTotal: " + chickenTotal + "\tSteakTotal: " + steakTotal);
				chickenVal = input.nextInt();
				steakVal = input.nextInt();

				if(j < numPeople-1){
					chickenTotal -= chickenVal;
					steakTotal -= steakVal;
				} 

				if(j == numPeople - 1)
				{
					if(steakTotal < 0 && chickenTotal < 0)
					{
						chickenTotal = 0;
						steakTotal = 0;
						break;
					}	

					if(steakTotal < 0)
					{
						steakTotal = 0;
					}
					else if(steakVal < steakTotal)
					{
						steakTotal = steakVal;
					}

					if(chickenTotal < 0)
					{
						chickenTotal = 0;
					}
					else if(chickenVal < chickenTotal)
					{
						chickenTotal = chickenVal;
					}
				}
			} // end j
			System.out.println(chickenTotal + " " + steakTotal);
		} // end i
	}
}
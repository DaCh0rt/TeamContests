import java.util.*;

public class burrito
{
	public static void main(String[] args)
	{
		//var decl.
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		int chickenTotal;
		int steakTotal;
		int numPeople;
		int chickenVal;
		int steakVal;

		//run thru cases
		for(int i = 0; i < numCases; i++)
		{	
			//read input
			chickenTotal = input.nextInt();
			steakTotal = input.nextInt();
			numPeople = input.nextInt();

			//go thru people and allocate meats
			for(int j = 0; j < numPeople; j++)
			{
				//System.out.println("chickenTotal: " + chickenTotal + "\tSteakTotal: " + steakTotal);
				chickenVal = input.nextInt();
				steakVal = input.nextInt();

				//if not last person
				if(j < numPeople-1){
					chickenTotal -= chickenVal;
					steakTotal -= steakVal;
				} 

				//if last person
				if(j == numPeople - 1)
				{
					//if we ran out
					if(steakTotal < 0 && chickenTotal < 0)
					{
						chickenTotal = 0;
						steakTotal = 0;
						break;
					}	

					//if steak ran out
					if(steakTotal < 0)
					{
						steakTotal = 0;
					}
					else if(steakVal < steakTotal)//else if wont
					{
						steakTotal = steakVal;
					}

					//if chicken ran out
					if(chickenTotal < 0)
					{
						chickenTotal = 0;
					}
					else if(chickenVal < chickenTotal)//else if wont
					{
						chickenTotal = chickenVal;
					}
				}
			} // end j

			//done, print
			System.out.println(chickenTotal + " " + steakTotal);
		} // end i
	}
}
import java.util.*;

public class paintme
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int numApartments = input.nextInt();
		int width, length, height, area;
		int numWindows;
		int windowW;
		int windowL;
		int windowTotal;
		int totalW, totalL, totalC, total;
		int cans;

		while(numApartments != 0)
		{
			width = input.nextInt();
			length = input.nextInt();
			height = input.nextInt();
			area = input.nextInt();
			numWindows = input.nextInt();
			windowW = 0;
			windowL = 0;
			totalW = 0;
			totalL = 0;
			totalC = 0;
			total = 0;
			cans = 0;
			windowTotal = 0;

			for(int i = 0; i < numWindows; i++)
			{
				windowW = input.nextInt();
				windowL = input.nextInt();
				windowTotal += windowW * windowL;
			}

			totalW = width * height;
			totalW = totalW * 2;

			totalL = length * height;
			totalL = totalL * 2;

			totalC = width * length;

			total = totalW + totalL + totalC - windowTotal;
			total = total * numApartments;

			cans = (int)Math.ceil((double)total / (double)area);

			System.out.println(cans);

			numApartments = input.nextInt();

		}
	}
}
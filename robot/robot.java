import java.util.*;

public class robot
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int numTargets = input.nextInt();
    int[] x;
    int[] y;
    int[] penalty;
    int[] totalPenalty;
    double[] cost;

    while(numTargets > 0)
    {
      x = new int[numTargets+2];
      y = new int[numTargets+2];
      penalty = new int[numTargets+2];
      totalPenalty = new int[numTargets+2];
      cost = new double[numTargets+2];

      // Start at (0,0)
      x[0] = 0;
      y[0] = 0;
      cost[0] = 0.0;

      // Read in the targets
      for(int i = 1; i <= numTargets; i++)
      {
        x[i] = input.nextInt();
        y[i] = input.nextInt();
        penalty[i] = input.nextInt();
        totalPenalty[i] = totalPenalty[i-1] + penalty[i];
      }

      // Set End Goal to (100, 100)
      x[numTargets+1] = 100;
      y[numTargets+1] = 100;
      totalPenalty[numTargets+1] = totalPenalty[numTargets];

      for(int i = 1; i <= numTargets + 1; i++)
      {
        // Current Cost is equal to the last cost + length to the new target + 1 second wait time
        cost[i] = cost[i-1] + calcLength(i-1, i, x, y) + 1.0;

        // Calculate remaining
        for(int j = i-2; j >= 0; j--)
        {
          cost[i] = Math.min(cost[i], cost[j] + calcLength(j, i, x, y) + 1.0 + totalPenalty[i-1] - totalPenalty[j]);
          // found the smallest cost
          if(cost[i] < totalPenalty[i-1] - totalPenalty[j])
            break;
        }
      }

      System.out.printf("%.3f %n", cost[numTargets+1]);

      numTargets = input.nextInt();
    } // end while
  } // end main

  // Calculates the length between two points
  public static double calcLength(int a, int b, int[] x, int[] y)
  {
    double distanceX =  x[a] - x[b];
    double distanceY = y[a] - y[b];

    // A sqrd + B sqrd = C sqrd
    return Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
  }
}

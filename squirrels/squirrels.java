//ian harvey

import java.util.*;

public class squirrels{
	public static final double pi = 3.141592653589793;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int c = in.nextInt();
		for(int i = 0; i < c; i++){
			
			int t = in.nextInt();
			Point[] pts = new Point[t];
			for(int j = 0; j < t; j++){
				pts[j] = new Point(in.nextInt(),in.nextInt());
			}

			double min = 1e9;
			for(int j = 0; j < t; j++){
				for(int k = j + 1; k < t; k++){
					double tmp = Math.sqrt(Math.pow(pts[j].x-pts[k].x,2) + Math.pow(pts[j].y-pts[k].y,2));
					if(tmp < min)
						min = tmp;
				}
			}
			double r = min/2;
			double a = pi * Math.pow(r,2);

			System.out.println("Campus #" + (i+1) + ":");
			System.out.printf("Maximum territory area = %.3f\n\n",a);

		}
	}
}

class Point{

	public int x;
	public int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
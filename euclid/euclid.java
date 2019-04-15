import java.util.*;

public class euclid {
	
	public static void main(String[] args) {
		
		Scanner fin = new Scanner(System.in);
		
		pt[] abc = new pt[3];
		pt[] def = new pt[3];
		
		//read a,b,c
		for (int i=0; i<3; i++) {
			double one = fin.nextDouble();
			double two = fin.nextDouble();
			abc[i] = new pt(one,two);
		}
		
		//read d,e,f
		for (int i=0; i<3; i++) {
			double one = fin.nextDouble();
			double two = fin.nextDouble();
			def[i] = new pt(one,two);
		}
		
		//run thru cases, end with a line of 0.0's
		while (!zero(abc) || !zero(def)) {
			
			//get area of triangle def. which is half the area of parallelogram def
			vector de = new vector(def[0], def[1]);
			vector df = new vector(def[0], def[2]);
			double areadef = 0.5*de.crossMag(df);
			
			//get the area of the parallelogram implied with abc.
			vector ab = new vector(abc[0], abc[1]);
			vector ac = new vector(abc[0], abc[2]);
			double areapara = ab.crossMag(ac);
			
			//get the ratio of the areas of def to the parallelogram.
			double factor = areadef/areapara;
			
			//this really is the vector ah, a ratio of ac.
			vector ah = ac.scaleFactor(factor);
			pt H = abc[0].addVect(ah);
			pt G = H.addVect(ab);
			
			//print out our answer.
			System.out.printf("%.3f %.3f %.3f %.3f\n",G.x+1e-9,G.y+1e-9,H.x+1e-9,H.y+1e-9);
			
			//prep input for next case
			abc = new pt[3];
			def = new pt[3];
		
			for (int i=0; i<3; i++) {
				double one = fin.nextDouble();
				double two = fin.nextDouble();
				abc[i] = new pt(one,two);
			}
		
			for (int i=0; i<3; i++) {
				double one = fin.nextDouble();
				double two = fin.nextDouble();
				def[i] = new pt(one,two);
			}
		}
	}
	
	// Returns true if all points are (0,0) in the array.
	public static boolean zero(pt[] array) {
		for (int i=0; i<array.length; i++)
			if (Math.abs(array[i].x) > 1e-9 || Math.abs(array[i].y) > 1e-9)
				return false;
		return true;
	}
}

class pt {
	public double x;
	public double y;
	
	public pt(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public pt addVect(vector v) {
		double newx = x+v.i;
		double newy = y+v.j;
		return new pt(newx,newy);
	}
	
}

class vector {
	public double i;
	public double j;

	public vector(pt start, pt end) {
		i = end.x - start.x;
		j = end.y - start.y;
	}
	
	public vector(double a, double b) {
		i = a;
		j = b;
	}

	public double crossMag(vector other) {
		return Math.abs(this.i*other.j-other.i*this.j);
	}
	
	public vector scaleFactor(double factor) {
		return new vector(i*factor, j*factor);
	}
}
		
		
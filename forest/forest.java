import java.util.*;

public class forest{
	public static int c;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		c = in.nextInt();

		pt[] pts = new pt[n];
		for(int i = 0; i < n; i++){
			int x = in.nextInt();
			int y = in.nextInt();
			pts[i] = new pt(x,y);
		}

		int refIndex = 0;
		for(int i = 1; i < pts.length; i++){
			if (pts[i].y < pts[refIndex].y || (pts[i].y == pts[refIndex].y && pts[i].x < pts[refIndex].x))
				refIndex = i;
		}
		pt.refX = pts[refIndex].x;
		pt.refY = pts[refIndex].y;

		//call graham scan
		superGrahamScan(pts);
	}

	public static void superGrahamScan(pt[] pts){

		double area = 0;
		double res = 0;
		if(pts.length > 2) {
			Arrays.sort(pts);

			Stack<pt> myStack = new Stack<pt>();
			myStack.push(pts[0]);
			myStack.push(pts[1]);

			for(int i = 2; i < pts.length; i++){
				pt cur = pts[i];
				pt mid = myStack.pop();
				pt prev = myStack.pop();

				while(!prev.isRightTurn(mid,cur)){
					mid = prev;
					prev = myStack.pop();
				}

				myStack.push(prev);
				myStack.push(mid);
				myStack.push(cur);
			}

			//calculate area of scan minus border.
			pt cur = pts[0];
			pt x = cur,y = null,z = null;
			while(myStack.size() > 0){
				pt next = myStack.pop();
				res += cur.dist(next);
				cur = next;

				if(y ==  null){
					y = cur;
				} else if(z == null){
					z = cur;
				}

				if(y!=null&&z!=null){

					if(myStack.size()>0){
						// System.out.println(x + " " + y + " " + z);
						area += 0.5 * x.getVect(y).crossMag(x.getVect(z));
					}

					z = y;
					y = null;
				}
			}
		} else if (pts.length > 1){
			res = pts[0].dist(pts[1]);
		} else if (pts.length == 0){
			c = 0;
		}
		double rectangles = c*res;
		double corners = Math.PI*c*c;
		double tarea = area + rectangles + corners;
		double perimmiter = 2*Math.PI*c + res;
		
		System.out.printf("%.2f %.2f\n",perimmiter,tarea);
	}
}

class pt implements Comparable<pt>{
	public static int refX;
	public static int refY;

	public int x;
	public int y;

	public pt(int x, int y){
		this.x = x;
		this.y = y;
	}

	// Returns the vector from this to other.
	public pt getVect(pt other){
		return new pt(other.x-x, other.y-y);
	}

	// Returns the distance between this and other.
	public double dist(pt other) {
		return Math.sqrt((other.x-x)*(other.x-x) + (other.y-y)*(other.y-y));
	}

	// Returns the magnitude ot this cross product other.
	public int crossProductMag(pt other) {
		return this.x*other.y - other.x*this.y;
	}

	public double crossMag(pt other) {
		return Math.abs(this.x*other.y-other.x*this.y);
	}

	// returns true iff this to mid to next is a right turn (180 degree is considered right turn).
	public boolean isRightTurn(pt mid, pt next) {
		pt v1 = getVect(mid);
		pt v2 = mid.getVect(next);
		return v1.crossProductMag(v2) >= 0; /*** Change to > 0 to skip collinear points. ***/
	}

	// Returns true iff this pt is the origin.
	public boolean isZero() {
		return x == 0 && y == 0;
	}

	public int compareTo(pt other) {

		pt myRef = new pt(refX, refY);
		pt v1 = myRef.getVect(this);
		pt v2 = myRef.getVect(other);

		// To avoid 0 issues.
		if (v1.isZero()) return -1;
		if (v2.isZero()) return 1;

		// Angles are different, we are going counter-clockwise here.
		if (v1.crossProductMag(v2) != 0)
			return -v1.crossProductMag(v2);

		// This should work, smaller vectors come first.
		if (myRef.dist(v1) < myRef.dist(v2)) return -1;
		return 1;
	}

	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
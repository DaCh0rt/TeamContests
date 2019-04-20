import java.util.*;

public class avl{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and run thru them
		int t = in.nextInt();
		for(int i = 0; i < t; i++){

			int n = in.nextInt();
			//bc
			if(n == 0){
				System.out.println("Tree #" + (i+1) + ": KEEP");
				continue;
			}

			//init root
			node root = new node(in.nextInt(),1);

			//insert values 1 by one
			boolean balanced = true;
			for(int j = 1; j < n; j++){
				int val = in.nextInt();

				if(balanced)
					balanced = insert(root, val);
			}

			//if it didnt fail
			if(balanced)
				System.out.println("Tree #" + (i+1) + ": KEEP");
			else
				System.out.println("Tree #" + (i+1) + ": REMOVE");

		}
	}

	public static boolean insert(node root, int val){
		boolean res = false;

		//insert into tree
		if (val < root.val){
			if(root.left == null){
				node child = new node(val,1);
				root.left = child;
				res = true;
			} else {
				res = insert(root.left,val);
			}
		} else {
			if(root.right == null){
				node child = new node(val,1);
				root.right = child;
				res = true;
			} else{
				res = insert(root.right,val);
			}
		}

		//avl heights
		int hLeft,hRight;
		if (root.left == null){
			hLeft = 0;
		} else {
			hLeft = root.left.height;
		}

		if (root.right == null){
			hRight = 0;
		} else {
			hRight = root.right.height;
		}

		//set root height
		root.height = (int)Math.max(hLeft,hRight) + 1;
		// root.height = hLeft + hRight + 1;
		// System.out.println("left: " + hLeft + "\tright: " +  hRight);

		//check if imbalance
		if(!res)
			return false;
		else if(Math.abs(hRight-hLeft) > 1){
			return false;
		}
		else
			return true;
	}
}

class node{
	public node left;
	public node right;
	public int val;
	public int height;

	public node(int v, int h){
		this.val = v;
		this.height = h;
	}
}
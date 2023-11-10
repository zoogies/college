package assignment_4;

// class for creating County objects
class County {
	String name;
	int FIPS;
	String seat;
	int population;
	double area;
	
	public County(String n, int f, String s, int p, double a) {
		name = n;
		FIPS = f;
		seat = s;
		population = p;
		area = a;
	}
}

// class for creating TreeNode objects
class TreeNode {
	County county_info; // the reference to the information of the county
	TreeNode left; 		// reference to the left child
	TreeNode right; 	// reference to the right child
	
	public TreeNode(County c) {
		county_info = c;
		left = null;
		right = null;
	}
}

// Binary Search Tree Class
class BST {
	TreeNode root;
	
	public BST() {
		root = null;
	}
	
	// add a node to the BST
	public TreeNode addNode(TreeNode node, County c) {
		// node is null, add it
		if(node == null) {
			node = new TreeNode(c);
			return node;
		}
		
		// add the node to the left or right accordingly
		if(c.FIPS < node.county_info.FIPS) {
			node.left = addNode(node.left, c);
		}
		else if(c.FIPS > node.county_info.FIPS) {
			node.right = addNode(node.right,c);
		}

		return node;
	}
	
	// remove a node from the BST based on its key (FIPS)
	public TreeNode removeNode(TreeNode root, int key) {
		// base case (used to actually delete the value)
		if (root == null) {
	        return root;
	    }

	    // search for desired node
	    if (key < root.county_info.FIPS) {
	        root.left = removeNode(root.left, key);
	    }
	    else if (key > root.county_info.FIPS) {
	        root.right = removeNode(root.right, key);
	    }
	    else {
	        // found node, if it has 0-1 children delete and potentially replace with child
	        if (root.left == null) {
	            return root.right;
	        }
	        else if (root.right == null) {
	            return root.left;
	        }

	        // in the case of two children, find the successor (smallest key in the right subtree) (so traverse left nodes)
	        TreeNode successor = root.right;
	        while (successor.left != null) {
		        root = root.left;
		    }

	        // copy the data from the successor
	        root.county_info = successor.county_info;

	        // delete successor (this wont remove the copy we just replaced with because we start at the right subtree of the copy)
	        root.right = removeNode(root.right, successor.county_info.FIPS);
	    }

	    return root;
	}
	
	// node, then left subtree, then right subtree
	public void displayPre(TreeNode n) {
		if(n == null) {
			return;
		}
		System.out.println(
				n.county_info.FIPS + " " +
				n.county_info.name + " " +
				n.county_info.seat + " " +
				n.county_info.population + " " +
				n.county_info.area + " "
		);
		displayPre(n.left);
		displayPre(n.right);
	}
	
	// left subtree, then right subtree, then node
	public void displayPost(TreeNode n) {
		if(n == null) {
			return;
		}
		displayPost(n.left);
		displayPost(n.right);
		System.out.println(
				n.county_info.FIPS + " " +
				n.county_info.name + " " +
				n.county_info.seat + " " +
				n.county_info.population + " " +
				n.county_info.area + " "
		);
	}
}

// testbed demonstrating that the code works
public class Assign {

	public static void main(String[] args) {

		/*
		 * Construct Counties
		 */
		County Franklin = new County("Franklin",49,"Columbus",1264518,539.87);
		County Hamilton = new County("Hamilton",61,"Cincinnati",802374,407.36);
		County Butler = new County("Butler",17,"Hamilton",368130,467.27);
		County Montgomery = new County("Montgomery",113,"Dayton",535153,461.68);
		County Clinton = new County("Clinton",27,"Wilmington",42040,410.88);
		County Cuyahoga = new County("Cuyahoga",35,"Cleveland",1249352,458.49);
		
		/*
		 * Construct Tree
		 */
		BST tree = new BST();

		/*
		 * Add initial nodes
		 */
		tree.root = tree.addNode(tree.root,Franklin);
		tree.addNode(tree.root,Hamilton);
		tree.addNode(tree.root,Butler);
		tree.addNode(tree.root,Montgomery);
		tree.addNode(tree.root,Clinton);
		
		/*
		 * Display pre and post
		 */
		System.out.println("Pre order:");
		tree.displayPre(tree.root);
		System.out.println("");
		System.out.println("Post order:");
		tree.displayPost(tree.root);
		System.out.println("");
		
		/*
		 * Add Cuyahoga
		 */
		tree.addNode(tree.root,Cuyahoga);
		
		/*
		 * Display pre and post
		 */
		System.out.println("Pre order:");
		tree.displayPre(tree.root);
		System.out.println("");
		System.out.println("Post order:");
		tree.displayPost(tree.root);
		System.out.println("");
		
		/*
		 * Explanation
		 */
		System.out.println("The node was inserted correctly based off its FIPS key, because it was placed to the right of that parent node's left child's right child node, (as key (35) is < 49 and > 17 and > 27)\n");
		
		/*
		 * Remove franklin by its FIPS
		 */
		tree.removeNode(tree.root,49);
		
		/*
		 * Display pre and post
		 */
		System.out.println("Pre order:");
		tree.displayPre(tree.root);
		System.out.println("");
		System.out.println("Post order:");
		tree.displayPost(tree.root);
		System.out.println("");
		
		/*
		 * Explanation
		 */
		System.out.println("The node was delted correctly, because we took the minimum node from the right subtree of the deleted node and replaced with it.");
	}
}
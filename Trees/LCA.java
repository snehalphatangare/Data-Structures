/*
 * Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to find the least common ancestor.
 */
package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*class Node {

	int data;
	Node left;
	Node right;
	
	public Node(){
		left=right=null;
	}
	
	public Node(int val)
	{
		left=right=null;
		data=val;
	}
	
	public boolean isLeaf(){
		if(this.left==null && this.right==null)
			return true;
		return false;
	}
}*/


public class LCA {
	Node root;
	//Booleans to note if both nodes are present in tree
	static boolean v1 = false, v2 = false;
	
	//Approach1: Arrays to store paths to nodes
	static List<Integer> path1= new ArrayList<>();
    static List<Integer> path2 = new ArrayList<>();
	
	public LCA() {
		root = null;
	}
	
	LCA(int val){
		root = new Node(val);
	}
	
	public void preOrderTraversal(Node root){
		if(root!=null){
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	/*Approach 1: Storing paths to nodes
	1) Find path from root to n1 and store it in a array
	2) Find path from root to n2 and store it in another array.
	3) Traverse both paths from right till the values in arrays are same. 
	T.C = O(N) . Requires 3 tree traversals. But extra space for storing paths is required
	*/
	private static int  findLCAStoringPaths(Node root,int n1,int n2){
		if(!findPath(root,n1,path1)){
			System.out.println("Element "+n1+" is not present");
			return -1;
		}
		else if(!findPath(root,n2,path2)){
			System.out.println("Element "+n2+" is not present");
			return -1;
		}
		//Both elements present. Paths are found. Find the LCA
		int i = 0;
        for ( ; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i-1);
	}
	
	private static boolean findPath(Node root, int n, List<Integer> path)
    {
        if (root == null) {
            return false;
        }
 
        path.add(root.data);
 
        if (root.data == n) {
            return true;
        }
 
        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
 
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
 
        path.remove(path.size()-1);
 
        return false;
    }
	/*Approach 2: Using single traversal
	Traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present). 
	If root doesn’t match with any of the keys, we recur for left and right subtree. The node which has one key present in its left subtree and the other key present in right subtree is the LCA. 
	If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
	T.C = O(N)
	*/
	
	/*
	 * This is the basic implementation assuming both nodes are present in tree. 
	 * (Only for reference to understand the next findLCA() implementation )
	 */
	public Node lowestCommonAncestor(Node root, int n1, int n2) {
	    if(root==null)
	        return null;
	 
	    if(root.data==n1 || root.data==n2)
	        return root;
	 
	    Node l = lowestCommonAncestor(root.left, n1, n2);
	    Node r = lowestCommonAncestor(root.right, n1, n2);
	 
	    if(l!=null&&r!=null){
	        return root;
	    }else{
	        return l!=null?l:r;
	    }
	}
	
	private static Node findLCA(Node root,int n1,int n2){
		 Node lca = findLCAUtil(root, n1, n2);
        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2)
            return lca;
        // Else return NULL
        return null;
		
	}
	
	private static Node findLCAUtil(Node node,int n1,int n2){
		if(node==null)
			return null;
		
		// Look for keys in left and right subtrees
        Node left_lca = findLCAUtil(node.left, n1, n2);
        Node right_lca = findLCAUtil(node.right, n1, n2);
        
        if(node.data==n1){
			v1=true;
			return node;
		}
		if(node.data==n2){
			v2=true;
			return node;
		}
		
        // If both of the above calls return Non-NULL, then one key is present in LST and other is present in RST. So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;
 
        // Otherwise both keys are in either LST or RST and return the respective LCA
        return (left_lca != null) ? left_lca : right_lca;
	}
	
	public static void main(String[] args) {
		/*Scanner scan = new Scanner(System.in);
		 System.out.println("\n Enter node1  ");
         int n1 = scan.nextInt();    
         System.out.println("\n Enter node2  ");
         int n2 = scan.nextInt();    */
		int n1=1, n2=3;
		
		// TODO Auto-generated method stub
         LCA tree  = new LCA(1);
		tree.root.left= new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left= new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.left= new Node(6);
		tree.root.right.right=new Node(7);
		
		System.out.println("\n Pre Order Traversal: ");
		tree.preOrderTraversal(tree.root);
		System.out.println();
		
		int lca=findLCAStoringPaths(tree.root,n1,n2);
		if(lca!=-1)
			System.out.println("The LCA of nodes "+ n1+" "+n2+" is "+ lca);
		else
			System.out.println("Keys are not present");
		
		Node LCA=findLCA(tree.root,n1,n2);
		if(LCA!=null)
			System.out.println("The LCA of nodes "+ n1+" "+n2+" is "+ LCA.data);
		else
			System.out.println("Keys are not present");
	}

}

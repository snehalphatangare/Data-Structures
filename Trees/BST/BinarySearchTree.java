package Trees.BST;

import java.util.Scanner;

class Node {

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
}


public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(int val){
		root = new Node(val);
	}
	
	public void inOrderTraversal(Node root){
		if(root!=null){
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}
	/*
	 * Time Complexity: The worst case time complexity of search and insert operations is O(h) where h is height of Binary Search Tree. 
	 * In worst case, we may have to travel from root to the deepest leaf node.
	 * The height of a skewed tree may become n and the time complexity of search and insert operation may become O(n).
	 */
	
	/* A recursive function to insert a new key in BST */
    private static Node insert(Node root, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
 
        return root;
    }
    
    //Recursive function Search a given node in BST
    public static Node searchRecursive(Node root, int key)
    {
        // Base Cases: root is null or key is present at root
        if (root==null || root.data==key)
            return root;
     
        // val is greater than root's key
        if (root.data > key)
            return searchRecursive(root.left, key);
        else // val is less than root's key
        	return searchRecursive(root.right, key);
    }
    
    //Iterative function Search a given node in BST
    public static void searchNR(Node root, int key)
    {
        while(root!=null && root.data!=key){
        	if(root.data == key){
        		System.out.printf("\n Node %d found in BST ", key);
        		return;
        	}
        	else if(key < root.data)
        		root=root.left;
        	else
        		root=root.right;
        }
        if(root.data == key)
        	System.out.printf("\n Node %d found in BST ", key);
        else
        	System.out.printf("\n Node %d not found in BST ", key);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree  = new BinarySearchTree(50);
		//insert(tree.root,50);
        insert(tree.root,30);
        insert(tree.root,20);
        insert(tree.root,40);
        insert(tree.root,70);
        insert(tree.root,60);
        insert(tree.root,80);
		System.out.println("\n In Order Traversal: ");
		tree.inOrderTraversal(tree.root);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter the node value to find ");
        int key = scan.nextInt();
		Node n=searchRecursive(tree.root,key);
		if(n==null)
			System.out.printf("\n Node %d not found in BST ", key);
		else 
			System.out.printf("\n Node %d found in BST ", key);
		
		searchNR(tree.root,key);
	}

}

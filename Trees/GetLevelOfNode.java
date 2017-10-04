package Trees;

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


public class GetLevelOfNode {
	Node root;
	
	public GetLevelOfNode() {
		root = null;
	}
	
	GetLevelOfNode(int val){
		root = new Node(val);
	}
	
	public void preOrderTraversal(Node root){
		if(root!=null){
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	private static int getLevelOfNode(Node root,int val,int level){
		if(root==null)
			return 0;
		else if(root.data==val){
			return level;
		}
		int result=getLevelOfNode(root.left,val,level+1);
		if(result!=0){ //If fount in LST
			return result;
		}
		else{
			return getLevelOfNode(root.right,val,level+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		 System.out.println("\n Enter the node to find level ");
         int data = scan.nextInt();      
		
		// TODO Auto-generated method stub
		BinaryTree tree  = new BinaryTree(1);
		tree.root.left= new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left= new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.left= new Node(6);
		tree.root.right.right=new Node(7);
		
		System.out.println("\n Pre Order Traversal: ");
		tree.preOrderTraversal(tree.root);
		System.out.println();
		int level=getLevelOfNode(tree.root,data,1);
		System.out.println("The level of node "+ data+" is "+level);
	}

}

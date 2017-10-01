package Trees;

import java.util.Stack;

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


public class BinaryTree {
	Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	BinaryTree(int val){
		root = new Node(val);
	}
	
	public void preOrderTraversal(Node root){
		if(root!=null){
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	public void inOrderTraversal(Node root){
		if(root!=null){
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}
	
	public void postOrderTraversal(Node root){
		if(root!=null){
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	//*****Recursive algos use the system stack. So for Non-recursive i.e iterative solutions use stack DS
	/*Algo:
	 1. Push root in stack
	 2. Until stack is empty
	 	Pop and print node.data
	 	Push right child, then left (Bcz want to print left then right).
	 */
	public void preOrderTraversalNR(Node root){
		Stack<Node> s= new Stack<Node>();
		if(root==null){
			System.out.println("Tree is empty");
			return;
		}
		s.push(root);
		while(!s.isEmpty()){
			Node n=s.pop();
			System.out.print(n.data+" ");
			if(n.right!=null)
				s.push(n.right);
			if(n.left!=null)
				s.push(n.left);
		}
		
		
	}
	
	/*Algo:
	 1. Mark curr=root. Push root in stack
	 2. Until done !=true
	 	2.1 Push all left nodes of curr to stack until reach left leaf node. curr=curr.left
	 	2.1 Now pop, print and push its right to stack. curr= poppedNode.right
	 */
	public void inOrderTraversalNR(Node root){
		Stack<Node> s= new Stack<Node>();
		if(root==null){
			System.out.println("Tree is empty");
			return;
		}
		Node curr=root;
		Boolean done=false;
		while(!done){
			if(curr!=null){
				s.push(curr);
				curr=curr.left;
			}
			else{
				if(s.isEmpty())
					done=true;
				else{
					Node n= s.pop();
					
					System.out.print(n.data+" ");
					curr=n.right;
				}
					
			}
		}
	}
	
	/*Algo:
	 1. Push root in stack
	 2.  Until stack is empty
	 	2.1 Peek the stack
	 		If leaf node- pop and print it
	 		Else Push right child, then left (Bcz want to print left then right). Assign these pushed left & right nodes to null to make peeked node as leaf node. (bcz after printing 
	 		left & right we want to print this node)
	 */
	public void postOrderTraversalNR(Node root){
		Stack<Node> s= new Stack<Node>();
		if(root==null){
			System.out.println("Tree is empty");
			return;
		}
		s.push(root);
		while(!s.isEmpty()){
			Node n=s.peek();
			if(n.isLeaf()){
				s.pop();
				System.out.print(n.data+" ");
			}
			else{
				if(n.right!=null){
					s.push(n.right);
					n.right=null;
				}
				if(n.left!=null){
					s.push(n.left);
					n.left=null;
				}
			}
		}
	}
	
	public static void main(String[] args) {
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
		tree.preOrderTraversalNR(tree.root);
		
		System.out.println("\n In Order Traversal: ");
		tree.inOrderTraversal(tree.root);
		System.out.println();
		tree.inOrderTraversalNR(tree.root);
		
		System.out.println("\n Post Order Traversal: ");
		tree.postOrderTraversal(tree.root);
		System.out.println();
		tree.postOrderTraversalNR(tree.root);
	}

}

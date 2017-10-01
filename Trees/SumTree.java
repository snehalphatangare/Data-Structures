/*
 * Given a Binary Tree where each node has positive and negative values. 
 * Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. 
 */
package Trees;

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

public class SumTree {
	Node root;
	
	public SumTree() {
		root = null;
	}
	
	SumTree(int val){
		root = new Node(val);
	}
	
	public void preOrderTraversal(Node root){
		if(root!=null){
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	public int createSumTree(Node root){
		if(root==null)
			return 0;
		int old_val=root.data;
		if(!root.isLeaf()){
			root.data=createSumTree(root.left)+createSumTree(root.right);
			return old_val+root.data;
		}
		return root.data;
	}
	
	/*
	 * Given a Binary Tree where each node has positive and negative values. 
	 * Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.
	 */
	public int createSumTreeChangeLeafNodes(Node root){
		if(root==null)
			return 0;
		int old_val=root.data;
		root.data=createSumTreeChangeLeafNodes(root.left)+createSumTreeChangeLeafNodes(root.right);
		return old_val+root.data;
			
	}
	
	public void createTree(SumTree tree){
		tree.root= new Node(1);
		tree.root.left= new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left= new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.left= new Node(6);
		tree.root.right.right=new Node(7);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumTree tree  = new SumTree();
		tree.createTree(tree);
		
		System.out.println("\n Pre Order Traversal: ");
		tree.preOrderTraversal(tree.root);
		tree.createSumTree(tree.root);
		System.out.println("\n Pre Order Traversal of Sum Tree: ");
		tree.preOrderTraversal(tree.root);
		
		tree.createTree(tree);
		tree.createSumTreeChangeLeafNodes(tree.root);
		System.out.println("\n Pre Order Traversal of Sum Tree with leaf nodes changed to 0: ");
		tree.preOrderTraversal(tree.root);
		
	}

}

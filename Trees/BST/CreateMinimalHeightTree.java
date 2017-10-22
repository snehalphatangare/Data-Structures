/*
 * Given a sorted array write an algorithm to create BST with minimal height
 */
package Trees.BST;
public class CreateMinimalHeightTree {
	
	Node root;
	
	public CreateMinimalHeightTree() {
		root = null;
	}
	
	public void inOrderTraversal(Node root){
		if(root!=null){
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}
	
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
	
	/*
	 * Get the Middle of the array and make it root. Recursively do same for left half and right half
	 * T.C = O(n)
	 * T(n) = 2 T(n/2) + c
	 */
	private static Node createMinimalHeightTree(Node root,int[] inp,int low,int high){
		Node rt = null;
		if(low <= high){
			int mid= (low+high)/2;
			rt=insert(root,inp[mid]);
			createMinimalHeightTree(rt,inp,low,mid-1);
			createMinimalHeightTree(rt,inp,mid+1,high);
		}
		return rt;
	}
	 /*
     * 		4
     * 	2		6
     * 1 3	  5   7
     */
	
	private static int getMaximumDepth(Node root){
		if (root == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = getMaximumDepth(root.left);
            int rDepth = getMaximumDepth(root.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inpArray= new int[]{1,2,3,4,5,6,7};
		CreateMinimalHeightTree tree  = new CreateMinimalHeightTree();
		Node rt=createMinimalHeightTree(tree.root,inpArray,0,inpArray.length-1);
		
		System.out.println("\n In Order Traversal: ");
		tree.inOrderTraversal(rt);
		
		System.out.println(" \n height = "+getMaximumDepth(rt));
	}

}

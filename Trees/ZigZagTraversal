/********LEETCODE 103 *****/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if(root == null )
            return result;
            
        /*
        * The idea is to use a boolean to switch sides (left/right)
        * While you create next row elements for result, store them in a list of nodes for next iterations processing. (If return type array was of type node, this extra nextRow won't we needed. We would get currentRow =. result.get(result.size() -1 ))
        */
        result.add(new ArrayList(Arrays.asList(root.val)));
        List<TreeNode> currentRow = new ArrayList<TreeNode>();
        currentRow.add(new TreeNode(root.val, root.left, root.right));
        boolean startLeft = false; //Start from right of root
        
        while(true) { //Stop when no new element was added
            List<Integer> nextRowData =new ArrayList();
            List<TreeNode> nextRow = new ArrayList();
            //For each element in current row add it's children
            for(TreeNode ele: currentRow) {
                if(startLeft){
                    if(ele.left != null){
                        nextRowData.add(ele.left.val);
                        nextRow.add(ele.left);
                    }
                    if(ele.right != null){
                        nextRowData.add(ele.right.val);
                        nextRow.add(ele.right);
                    }
                }
                else {
                    if(ele.right != null){
                        nextRowData.add(ele.right.val);
                        nextRow.add(ele.right);
                    }
                    if(ele.left != null){
                        nextRowData.add(ele.left.val);
                        nextRow.add(ele.left);
                    }
                }
            }
            if(nextRowData.size() == 0)
                break;
            result.add(nextRowData);
            //Because for next row we have to start from the last element in prev row
            Collections.reverse(nextRow);
            currentRow = nextRow; 
            startLeft = !startLeft;
        }
        return result;
    }
}

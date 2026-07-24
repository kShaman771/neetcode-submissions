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

    private int preIndex = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store value -> index in inorder array
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right){

        // No nodes in this subtree
        if(left > right){
            return null;
        }

        // Current root comes from preorder
        int rootVal = preorder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder
        int mid = map.get(rootVal);

        // Build left subtree
        root.left = dfs(preorder, left, mid - 1);

        // Build right subtree
        root.right = dfs(preorder, mid + 1, right);

        return root;
    }
}
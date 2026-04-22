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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer min, Integer max) {
        // 1. if node is null return true
        if (node == null) return true;
        // 2. if left smaller minimum or right bigger maximum return false
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        // 3. recursion pre order: root, left, right: 
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}

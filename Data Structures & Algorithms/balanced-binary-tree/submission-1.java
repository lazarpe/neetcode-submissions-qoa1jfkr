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
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // Post order: L -> R -> Root
    // Get left height, get right height, go root to check diff.
    public int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        if (left == -1) return -1;

        int right = getHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);        
    }
}

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return helper(root, 0, targetSum);
    }

    public boolean helper(TreeNode node, int curr, int target) {
        if (node == null) return false;
        curr += node.val;
        if (node.left == null && node.right == null) {
            return curr == target;
        }
        return helper(node.left, curr, target) || helper(node.right, curr, target);
    }
}
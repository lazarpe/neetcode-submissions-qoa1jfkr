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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // key: number, value: index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length - 1, preorder, map);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> map) {
        // BASE CASE: If your slice has no size, the tree is empty
        if (inStart > inEnd) return null;

        // 1. The root is ALWAYS the first element of our current preorder slice
        TreeNode root = new TreeNode(preorder[preStart]);

        // 2. Find the "Divider" in the inorder array
        int m = map.get(root.val);

        // 3. RECURSION (The Slicing)
        
        // LEFT SLICE:
        // Inorder: Everything from 'inStart' up to 'm - 1'
        // Preorder: The very next element (preStart + 1)
        root.left = helper(preStart + 1, inStart, m - 1, preorder, map);

        // RIGHT SLICE:
        // Inorder: Everything from 'm + 1' to 'inEnd'
        // Preorder: Skip the root AND the entire left subtree
        int leftTreeSize = m - inStart; 
        root.right = helper(preStart + leftTreeSize + 1, m + 1, inEnd, preorder, map);

        return root;
    }
}

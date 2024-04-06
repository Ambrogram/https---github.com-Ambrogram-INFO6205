package MidtermProject.Problem2;

public class Solution {
    private int count = 0; // Counter for uni-value subtrees

    // Public method to be called to count uni-value subtrees
    public int countUnivalSubtrees(TreeNode root) {
        isUni(root);      // Initiate the recursive function
        return count;     // Return the final count
    }

    // Helper recursive method to determine if a node is the root of a uni-value subtree
    private boolean isUni(TreeNode node) {
        // Base case: if the node is null, it's considered a uni-value subtree
        if (node == null) return true;

        // Recursively check if left and right subtrees are uni-value
        boolean left = isUni(node.left);
        boolean right = isUni(node.right);

        // If both left and right are uni-value, check the current node's value
        if (left && right) {
            // If left child exists, check if its value matches the current node
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            // If right child exists, check if its value matches the current node
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            // If passed both checks, increment the counter as this is a uni-value subtree
            count++;
            return true; // Current subtree is uni-value
        }
        return false; // If either left or right is not uni-value, the current subtree isn't either
    }
}


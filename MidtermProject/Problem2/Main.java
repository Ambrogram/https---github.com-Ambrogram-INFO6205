package MidtermProject.Problem2;

public class Main {
    public static void main(String[] args) {
        // Example 1: Construct the binary tree [5, 1, 5, 5, 5, null, 5]
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(5);

        Solution solution = new Solution();
        System.out.println("Example 1: Expected output is 4, Actual output is: " + solution.countUnivalSubtrees(root1));

        // Example 2: An empty tree []
        TreeNode root2 = null;
        System.out.println("Example 2: Expected output is 0, Actual output is: " + solution.countUnivalSubtrees(root2));

        // Example 3: Construct the binary tree [5, 5, 5, 5, 5, null, 5]
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(5);
        root3.left.left = new TreeNode(5);
        root3.left.right = new TreeNode(5);
        root3.right.right = new TreeNode(5);
        
        System.out.println("Example 3: Expected output is 6, Actual output is: " + solution.countUnivalSubtrees(root3));
    }
}



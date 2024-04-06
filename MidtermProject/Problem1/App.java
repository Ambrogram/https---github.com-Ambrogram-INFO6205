package MidtermProject.Problem1;

public class App {
    public static void main(String[] args) {
        System.out.println("Example 2: Input root = []");
        TreeNode testRoot1 = null;
        Solution solution = new Solution();
        TreeNode result1 = solution.upsideDownBinaryTree(testRoot1);
        System.out.println("Output: " + (result1 == null ? "[]" : result1.val));  // Expected: []

        System.out.println("Example 3: Input root = [1]");
        TreeNode testRoot2 = new TreeNode(1);
        TreeNode result2 = solution.upsideDownBinaryTree(testRoot2);
        System.out.println("Output: " + (result2 == null ? "[]" : result2.val));  // Expected: [1]

        System.out.println("Additional Example: Input root = [1, 2, 3]");
        TreeNode testRoot3 = new TreeNode(1);
        testRoot3.left = new TreeNode(2);
        testRoot3.right = new TreeNode(3);
        TreeNode result3 = solution.upsideDownBinaryTree(testRoot3);
        System.out.print("Output: [");
        solution.printTree(result3);  // Expected: [2, 3, 1] or similar, depending on tree representation
        System.out.println("]");
    }
}


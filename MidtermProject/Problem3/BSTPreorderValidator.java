package MidtermProject.Problem3;

import java.util.Stack;

public class BSTPreorderValidator {
    
    // Method to validate if the given preorder traversal array can represent a BST
    public boolean isValidPreorder(int[] preorder) {
        // Stack to keep track of the nodes
        Stack<Integer> stack = new Stack<>();
        // This will hold the last value popped from the stack, representing the last root node
        // that we have fully processed its left subtree
        int lowerBound = Integer.MIN_VALUE;

        // Iterate through each value in the preorder traversal array
        for (int value : preorder) {
            // If we encounter a value less than the lower bound, it means the preorder sequence
            // cannot represent a BST because this value should have been on the left side of a root
            if (value < lowerBound) {
                return false;
            }

            // As long as we have a value larger than the stack's top, we are traversing the right subtree
            // The top of the stack is the parent, and we update the lower bound because all future values
            // need to be greater than this parent to form a valid BST
            while (!stack.isEmpty() && value > stack.peek()) {
                lowerBound = stack.pop();
            }

            // Add the current value to the stack. It might be the root of a subtree,
            // or a left/right child in the current tree
            stack.push(value);
        }

        // If the whole preorder array is traversed without issues, it represents a valid BST preorder traversal
        return true;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        BSTPreorderValidator validator = new BSTPreorderValidator();

        // Test Example 1
        int[] preorder1 = {5, 2, 1, 3, 6};
        System.out.println("Example 1: " + validator.isValidPreorder(preorder1)); // Expected: true

        // Test Example 2
        int[] preorder2 = {5, 2, 6, 1, 3};
        System.out.println("Example 2: " + validator.isValidPreorder(preorder2)); // Expected: false
    }
}


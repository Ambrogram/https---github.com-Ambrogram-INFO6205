import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class AverageofLevelsinBinaryTree637 {
    public List<Double> averageOflevels(TreeNode root){
        List<Double> averages = new ArrayList<>();
        if(root == null){
            return averages;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            long sum = 0; // Use long to avoid integer overflow
            int count = queue.size();// Number of nodes at the current level
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();// Remove the front node from the queue
                sum += node.val; // Add the node's value to the sum


                // Add the node's children to the queue if they exist
                if(node.left != null){
                    queue.add(node.left);

                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }

            // Calculate the average for the current level and add it to the result list
            averages.add((double) sum / count);
        }

        return averages;
    }
}
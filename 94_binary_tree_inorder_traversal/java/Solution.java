import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalRec(root, new ArrayList<>());
    }

    private List<Integer> inorderTraversalRec(TreeNode node, List<Integer> values) {
        if (node == null) {
            return values;
        }
        inorderTraversalRec(node.left, values);
        values.add(node.val);
        inorderTraversalRec(node.right, values);
        return values;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


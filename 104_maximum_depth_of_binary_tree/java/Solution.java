public class Solution {

    public int maxDepth(TreeNode root) {
        return traversalDepth(root, 0);
    }

    private int traversalDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        ++depth;
        return Math.max(traversalDepth(node.left, depth), traversalDepth(node.right, depth));
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


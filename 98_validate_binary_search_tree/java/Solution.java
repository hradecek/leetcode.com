import java.util.function.Predicate;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode subTree, Integer low, Integer high) {
        if (subTree == null) {
            return true;
        }

        if ((low != null && low >= subTree.val) || (high != null && high <= subTree.val)) {
            return false;
        }

        return validate(subTree.left, low, subTree.val) && validate(subTree.right, subTree.val, high);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


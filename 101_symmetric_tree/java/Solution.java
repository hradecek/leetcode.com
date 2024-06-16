public class Solution {

    public static void main(String[] args) {
        final var sym = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(3), new TreeNode(4)),
            new TreeNode(2,
                new TreeNode(4), new TreeNode(3))
        );
        final var asym = new TreeNode(1,
            new TreeNode(2,
                null, new TreeNode(3)),
            new TreeNode(2,
                null, new TreeNode(3))
        );
        final var solution = new Solution();
        System.out.println(solution.isSymmetric(sym));
        System.out.println(solution.isSymmetric(asym));
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
          isMirror(left.left, right.right) && 
          isMirror(left.right, right.left);
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

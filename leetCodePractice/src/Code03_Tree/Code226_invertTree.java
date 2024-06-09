package Code03_Tree;

public class Code226_invertTree {

    // 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = invertTree(left);
        root.left = invertTree(right);

        return root;
    }
}

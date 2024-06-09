package Code03_Tree;

public class Code543_diameterOfBinaryTree {
    int maxDiameter = 0;
    // 二叉树的直径
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTree2(root);
        return maxDiameter;
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;

        int left = diameterOfBinaryTree2(root.left);
        int right = diameterOfBinaryTree2(root.right);

        // 如果左树路径加右树大于最大直径，着将左树路径加右树的直径设置为最大直径
        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(left, right) + 1;
    }
}

package Code03_Tree;

public class Code111_minDepth {

    // 查找树的最小深度
    // BT树可以列出所有可能
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        int min = 0;
        if(left == 0) min = right;
        else if(right == 0) min = left;
        else min = Math.min(left, right);

        return min + 1;

    }

}

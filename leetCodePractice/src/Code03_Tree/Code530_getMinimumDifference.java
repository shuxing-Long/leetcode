package Code03_Tree;

public class Code530_getMinimumDifference {

    int minDiff = Integer.MAX_VALUE;
    TreeNode temp;

    // 最小插值
    // 使用中序遍历来实现
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return minDiff;
        }

        getMinimumDifference(root.left);

        if(temp != null){
            minDiff = Math.min(minDiff, Math.abs(temp.val-root.val));
        }
        temp = root;

        getMinimumDifference(root.right);

        return minDiff;

    }
}

package Code03_Tree;

import java.util.ArrayList;
import java.util.List;

public class Code112_hasPathSum {

    // 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
    // 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
    // 如果存在，返回 true ；否则，返回 false 。
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        int s = targetSum - root.val;
        // 如果当前节点为最后一个节点，并且targetSum将节点的值后为0 则为true
        if (root.left == null && root.right == null && s == 0 ) return true;

        boolean left = hasPathSum(root.left, s);
        boolean right = hasPathSum(root.right, s);

        return left || right;
    }
}

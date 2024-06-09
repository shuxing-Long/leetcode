package Code03_Tree;

public class Code404_sumOfLeftLeaves {
    // 左叶子之和
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null){
            return 0;
        }
        return sumOfLeftLeaves1(root,false);
    }
    // isb表示当前节点是否为左子节点
    public int sumOfLeftLeaves1(TreeNode root,boolean isb) {
        if(root == null){
            return 0;
        }

        int leftSum = sumOfLeftLeaves1(root.left,true);
        int rightSum = sumOfLeftLeaves1(root.right,false);

        if(root.left == null && root.right == null && isb){
            return leftSum + rightSum + root.val;
        }

        return leftSum + rightSum;
    }


}

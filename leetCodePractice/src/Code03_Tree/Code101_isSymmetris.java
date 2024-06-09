package Code03_Tree;

import java.util.ArrayList;
import java.util.List;

public class Code101_isSymmetris {

    // 判断树是否镜像轴对称
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        return inOrderRecur(root.left,root.right);
    }

    // 使用两个指针，判断左右是否对称
    public static Boolean inOrderRecur(TreeNode q,TreeNode p) {
        if(q == null && p == null){
            return true;
        }
        if (q == null || p == null){
            return false;
        }
        return q.val == p.val && inOrderRecur(q.left, p.right) && inOrderRecur(q.right, p.left);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(3);

        System.out.print(isSymmetric(root));
    }
}

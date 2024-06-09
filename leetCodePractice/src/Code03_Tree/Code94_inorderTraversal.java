package Code03_Tree;
import java.util.*;

public class Code94_inorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null || (root.left==null&&root.right==null)){
            List<Integer> list = new ArrayList<>();
            if(root != null){
                list.add(root.val);
            }
            return new LinkedList<Integer>(list);
        }
        List<Integer> list = new ArrayList<>();
        inOrderRecur(list,root);
        return list;
    }

    // 中序遍历
    public static void inOrderRecur(List<Integer> list,TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(list,root.left);
        list.add(root.val);
        inOrderRecur(list,root.right);
    }

}

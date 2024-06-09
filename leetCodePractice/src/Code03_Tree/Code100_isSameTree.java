package Code03_Tree;

public class Code100_isSameTree {

    boolean ifAlike = true;
    // 判断两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        inOrderRecur(p,q);
        return ifAlike;
    }

    // 遍历这个是当遇到不同的节点时，将ifAlike标记为false
    public  void inOrderRecur(TreeNode p , TreeNode q) {
        if(p == null && q == null && ifAlike){
            return;
        }
        if((p == null && q != null) || (p != null && q == null) ){
            ifAlike = false;
            return;
        }
        if(p.val != q.val){
            ifAlike = false;
        }
        inOrderRecur(p.left,q.left);
        inOrderRecur(p.right,q.right);
    }

//    // 别人的写法，return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//    // 这个递归只有所有节点都返回true时，最终的结果才是true, 有一个节点返回false,最终的结果就是false
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        } else if (p == null || q == null) {
//            return false;
//        } else if (p.val != q.val) {
//            return false;
//        } else {
//            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        }
//    }

    public static void main(String[] args) {

    }
}

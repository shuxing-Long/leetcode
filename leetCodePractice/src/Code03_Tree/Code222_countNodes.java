package Code03_Tree;

public class Code222_countNodes {
    // 统计完全二叉树的节点个数
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }
    // ===========================================================================
    // 别人的写法
    // 比N(O)更快的方法
    public int countNodes1(TreeNode root) {
        if(root == null){
            return 0;
        }
        // 统计当前节点的左子节点的所有左子节点的深度
        int left = countLevel(root.left);
        // 统计当前节点的右子节点的所有左子节点的深度
        int right = countLevel(root.right);
        // 如果left等于right， 则证明左子树是满的，这个时候只需要处理右子树就可以了
        // 如果left不等于right， 则证明右子树比左子树少了一层，这个时候只需要处理左子树的信息就可以了
        if(left == right){
            return countNodes1(root.right) + (1<<left);
        }else{
            return countNodes1(root.left) + (1<<right);
        }
    }
    // 统计传入节点的所有左子节点的深度
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }

}

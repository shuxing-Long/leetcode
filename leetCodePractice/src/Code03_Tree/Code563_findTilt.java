package Code03_Tree;

public class Code563_findTilt {

    int tilt=0;

    // 二叉树的坡度
    public int findTilt(TreeNode root) {

        findTilt1(root);
        return tilt;
    }

    public int findTilt1(TreeNode root){
        if (root == null) {
            return 0;
        }

        int left =  findTilt1(root.left);
        int right = findTilt1(root.right);

        tilt += Math.abs(left - right);

        return left+right+root.val;
    }

    public  void main(String[] args) {

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(7);

        System.out.println(findTilt(root));
    }
}

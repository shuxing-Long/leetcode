package Code03_Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Code104_maxDepth {

    // 二叉树的 最大深度
//    public static int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//
//        // 队列
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        HashMap<TreeNode, Integer> map = new HashMap<>();
//        map.put(root, 1);
//        // 先加头节点到队列中
//        queue.add(root);
//        // 层数
//        int depth = 1;
//        // 先序遍历
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.poll();
//            int curDepth = map.get(cur);
//            // 当当前层数遍历完，层数加1
//            if(curDepth != depth) {
//                depth++;
//            }
//
//            if (cur.left != null){
//                map.put(cur.left, curDepth+1);
//                queue.add(cur.left);
//            }
//            if (cur.right != null){
//                map.put(cur.right, curDepth+1);
//                queue.add(cur.right);
//            }
//        }
//        return depth;
//    }

    // 别人的写法
    public static int maxDepth(TreeNode root) {
        // def func: 返回子树长度
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.print(maxDepth(root));
    }
}

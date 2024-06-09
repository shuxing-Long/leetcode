package Code03_Tree;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Code257_binaryTreePaths {

    // 二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {


        List<String> paths = new ArrayList<String>();

        if (root.left == null && root.right == null) {
            paths.add(""+root.val);
            return paths;
        }

        binaryTree(root.left,""+root.val,paths);
        binaryTree(root.right,""+root.val,paths);
        return paths;
    }

    public void binaryTree(TreeNode treeNode , String path , List<String> result){
        if(treeNode == null){
            return;
        }
        path += "->"+treeNode.val;
        if(treeNode.left == null && treeNode.right == null){
            result.add(path);
            return;
        }
        binaryTree(treeNode.left,path,result);
        binaryTree(treeNode.right,path,result);
    }

    // ======================================================================================
    // 别人的写法
    // 这个方法只有在第一次调用get()或者size()时才将所有的路径找出来。
    public List<String> binaryTreePaths1(TreeNode root) {
        return new AbstractList<String>() {
            private final List<String> list = new ArrayList<>();
            // StringBuilder的使用减少了临时字符串对象的创建。
            private final StringBuilder sb = new StringBuilder();

            @Override
            public String get(int index) {
                init();
                return list.get(index);
            }

            @Override
            public int size() {
                init();
                return list.size();
            }

            void init() {
                // 只有第一次调用才执行代码
                if (list.isEmpty()) {
                    if (root == null) {
                        return;
                    }
                    sb.append(root.val);
                    traverseNode(root);
                }
            }

            void traverseNode(TreeNode tree){
                boolean isLeaf = true;
                if (tree.left != null) {
                    isLeaf = false;
                    writePath(tree.left);
                }
                if (tree.right != null) {
                    isLeaf = false;
                    writePath(tree.right);
                }
                if (isLeaf) {
                    list.add(sb.toString());
                }
            }

            void writePath(TreeNode tree) {
                int originalLen = sb.length();
                sb.append("->").append(tree.val);
                traverseNode(tree);
                sb.setLength(originalLen);
            }
        };
    }
}

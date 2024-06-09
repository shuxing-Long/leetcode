package Code03_Tree;

import java.util.LinkedList;
import java.util.Stack;

public class Code_publicFunctions {

    // 非递归的先序遍历(头左右)
    // (1) 开始将根节点压到栈里
    // (2) 从栈中弹出一个节点
    // (3) 先右再左。如果子节点不为空，则压到栈里
    // (4) 循环 (2) ~ (3)
    public void prefaceTraverse(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(treeNode);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }

        }
    }

    // 非递归的后序遍历(左右头)
    // (1) 开始将根节点压到栈里
    // (2) 从栈中弹出一个节点
    // (3) 将弹出的节点加到一个辅助栈中
    // (4) 先左再右。如果子节点不为空，则压到栈里
    // (5) 循环 (2) ~ (3)
    // (6) 循环结束后，打印辅助栈，结果就是后序
    public void postscriptTraverse(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(treeNode);

        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.add(node);

            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack1.push(node.right);
            }
        }
        // 打印第二个栈
        while(!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            System.out.println(node.val);
        }
    }

    // 非递归的中序遍历(左头右)
    public void mediumOrderTraverse(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        while(!stack1.isEmpty() || treeNode != null){
            if(treeNode != null){
                stack1.push(treeNode);
                treeNode = treeNode.left;
            }else {
                // 当前节点的使用左子节点走完后，弹出一个节点，将这个节点作为新的根节点，循环往复
                treeNode = stack1.pop();
                System.out.println(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }
// ===================================================================================
    // 判断是否是搜索二叉树
    // 这棵树： 左子节点小于头节点，右节点大于头节点
    public static int preValue = Integer.MIN_VALUE;
    public static boolean checkBST(TreeNode root){
        if(root == null){
            return true;
        }

        boolean isLeftBst = checkBST(root.left);
        if(!isLeftBst){
            return false;
        }
        if(root.val <= preValue){
            return false;
        }else {
            preValue = root.val;
        }
        return checkBST(root.right);
    }

    // 使用递归方式判断
    public static class ReturnData{
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean isBST, int min, int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnData process1(TreeNode root){
        if(root == null){
            return  null;
        }

        ReturnData leftData = process1(root.left);
        ReturnData rightData = process1(root.right);

        int min = root.val;
        int max = root.val;

        if(leftData != null){
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if(rightData != null){
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        boolean isBST = true;
        if(leftData!=null && (!leftData.isBST || leftData.max >= root.val)){
            isBST = false;
        }

        if(rightData!=null && (!rightData.isBST || root.val >= rightData.min )){
            isBST = false;
        }

        return new ReturnData(isBST, min, max);
    }

 // ===================================================================================


    // 判断是否是完全二叉树
    public static boolean isCBT(TreeNode root){
        if(root == null){
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        // 是否遇过左右两个孩子不双全的节点
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(root);

        while(!queue.isEmpty()){
            root = queue.poll();
            l = root.left;
            r = root.right;
            // 遇到左边没有，右边有，则为false
            if((leaf && (l!=null || r!=null)) || (l == null && r != null)){
                return false;
            }

            if(l != null){
                queue.add(l);
            }

            if(r != null){
                queue.add(r);
            }

            if(l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }

    // 判断满二叉树， 最大深度：l , 节点树： N   判断: N = 2^l - 1
    // (1)如果二叉树问题是一个树型DP,就可以使用以下的方式解决
    // (2)树型DP: 如果可以通过向左右树要信息，来解决最终问题的二叉树问题结束树型DP
    // (3)列出使用可能和需要的信息
    // (4)不是使用的树型问题都可以用这种方式解决
    public static boolean isF(TreeNode root){
        if(root ==null){
            return true;
        }
        Info data = f(root);
        //1 << data.height 等同于2^l
        return data.nodes == (1 << data.height - 1);
    }

    public static class Info{
        public int height;
        public int nodes;

        public Info(int h,int n){
            this.height = h;
            this.nodes = n;
        }
    }

    public static Info f(TreeNode x){
        if(x == null){
            return  new Info(0,0);
        }

        Info leftData = f(x.left);
        Info rightData = f(x.right);

        int height = Math.max(leftData.height,rightData.height)+1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new Info(height,nodes);
    }



    // 判断平衡二叉树(左右高度差不大于1)
    public static boolean isBalanced(TreeNode root){
        return process(root).isBalanced;
    }

    public static class ReturnType{
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int hei){
            this.isBalanced = isB;
            this.height = hei;
        }
    }

    public static ReturnType process(TreeNode x){
        if(x == null){
            return new ReturnType(true, 0);
        }

        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;

        return new ReturnType(isBalanced, height);
    }



    //===============================================================================
    // 查找两个子节点的最低公共祖先
    public static TreeNode lowestAncestor(TreeNode head,TreeNode o1 , TreeNode o2){
        if(head == null || head == o1 || head == o2){
            return head;
        }
        TreeNode left = lowestAncestor(head.left, o1, o2);
        TreeNode right = lowestAncestor(head.right, o1, o2);
        if(left != null && right != null){
            return head;
        }
        // 左右两棵树，并不都有返回值
        return left != null ? left : right;
    }
}

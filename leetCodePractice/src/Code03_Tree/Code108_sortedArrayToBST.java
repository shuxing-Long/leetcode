package Code03_Tree;

public class Code108_sortedArrayToBST {

    // 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBst(nums, 0, nums.length - 1);
    }


    public TreeNode arrayToBst(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        // 选中间节点做为头节点
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = arrayToBst(nums, start, mid - 1);
        root.right = arrayToBst(nums, mid + 1, end);
        return root;

    }
}

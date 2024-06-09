package Code03_Tree;

import java.util.*;

public class Code501_findMode {
    // 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
    //如果树中有不止一个众数，可以按 任意顺序 返回。
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = findMode1(root,map);
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxSum) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int findMode1(TreeNode root,HashMap<Integer, Integer> result) {

        if (root == null) return 0;
// 当哈希表不存在这个值时
        if (result.containsKey(root.val) ) {
            result.put(root.val,result.get(root.val)+1);

        }else {
            result.put(root.val,1);
        }
        int left = findMode1(root.left,result);
        int right = findMode1(root.right,result);

        return Math.max(result.get(root.val),Math.max(left,right));
    }



    //=======================================================================================
    // 别人的写法
    int times = 0;
    TreeNode temp;
    int max = 0;
    List<Integer> res = new LinkedList<>();

    public int[] findMode1(TreeNode root) {
        find(root);
        int len = res.size();
        int[] result = new int[len];
        for(int i = 0; i < len; i++){
            result[i] = res.get(i);
        }
        return result;
    }
    public void find(TreeNode root) {
        if(root == null)    return;

        find(root.left);
        // 第一次进来时，将当前节点加到众数集合中，并把当前数出现的次数和最大次数初始化为1
        // 中序遍历
        if(temp == null){
            times = 1;
            max = 1;
            res.add(root.val);
        }else{
            // 如果当前节点数和前一个数相同,则当前数出现次数加1
            if(root.val == temp.val){
                times++;
            }else if(root.val != temp.val){
                // 反之，则当前数回复为1
                times = 1;
            }
            if(times == max){
                // 如果当前数出现次数和最大次数相等，则认为它是一个众数
                res.add(root.val);
            }else if(times > max){
                // 如果当前数出现次数大于最大次数，则清空众数列表，将当前数加到众数列表中
                res.clear();
                res.add(root.val);
                // 将最大次数设置为当前数的出现次数
                max = times;
            }
        }
        temp = root;

        find(root.right);
    }
}

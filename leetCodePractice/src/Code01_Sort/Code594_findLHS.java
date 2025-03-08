package Code01_Sort;

import java.util.HashMap;

public class Code594_findLHS {
    /*
    * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
    现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
    数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
    *
    * */
    public static int findLHS(int[] nums) {
        if(nums.length == 2){
            if(Math.abs(nums[0]-nums[1])==1){
                return 2;
            }
            return -1;
        }
        // 存储每个数出现的次数
        HashMap<Integer,Integer> hashNum = new HashMap<>();
        for (int num:nums) {
            if(hashNum.containsKey(num)){
                hashNum.put(num,hashNum.get(num)+1);
            }else {
                hashNum.put(num,1);
            }
        }
        // 最大的数
        int maxNum=Integer.MIN_VALUE;
        // 将当前数与前一个数相加然后比较
        for (int i : hashNum.keySet()){
            if(hashNum.containsKey(i+1)){
                maxNum = Math.max(maxNum,hashNum.get(i)+hashNum.get(i+1));
            }
        }
        return maxNum == Integer.MIN_VALUE ? 0:maxNum;
    }
    /*
    *示例 1：
    输入：nums = [1,3,2,2,5,2,3,7]
    输出：5
    解释：最长的和谐子序列是 [3,2,2,2,3]
    示例 2：
    输入：nums = [1,2,3,4]
    输出：2
    示例 3：
    输入：nums = [1,1,1,1]
    输出：0
    *
    * */
    public static void main(String[] args) {
       System.out.println(findLHS(new int[]{3,2,0,0,0,3,2,2,0,2,2,1,2,3,1,0,2,3,2,3,3,2,1,0,3,3,1}));
    }
}

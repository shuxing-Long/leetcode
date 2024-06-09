package code01_Sort;

import java.util.Arrays;

public class Code1005_largestSumAfterKNegations {
    /*
    * 1005. K 次取反后最大化的数组和
    给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
    选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
    重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
    以这种方式修改数组后，返回数组 可能的最大和 。
    * */
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int sum=0;
        int min=Integer.MAX_VALUE;
        int minIndex = 0;
        Arrays.sort(nums);
        // 先遍历一遍，(1)把k个负数转换
        for (int i=0;i<nums.length;i++){
            if(k>0&&nums[i]<0){
                nums[i]= -nums[i];
                k--;
            }
            if(min>nums[i]){
                min= nums[i];
                minIndex=i;
            }
            sum+=nums[i];
        }
        if(k>0&&k%2!=0){
            sum-=(nums[minIndex]*2);
        }
        return sum;
    }

    /*
    *示例 1：
    输入：nums = [4,2,3], k = 1
    输出：5
    解释：选择下标 1 ，nums 变为 [4,-2,3] 。
    *
    示例 2：
    输入：nums = [3,-1,0,2], k = 3
    输出：6
    解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
    *
    示例 3：
    输入：nums = [2,-3,-1,5,-4], k = 2
    输出：13
    解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
    * */
    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{2,-3,-1,5,-4},2));
    }
}

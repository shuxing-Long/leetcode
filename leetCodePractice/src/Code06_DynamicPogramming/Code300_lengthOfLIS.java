package Code06_DynamicPogramming;

public class Code300_lengthOfLIS {
    // 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
    // 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        // dp[i] 是当前的最长子序列
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}

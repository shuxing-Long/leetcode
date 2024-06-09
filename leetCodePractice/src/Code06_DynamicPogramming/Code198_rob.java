package Code06_DynamicPogramming;

public class Code198_rob {
    // 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
    // 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    //给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // 存储前两次和前三次的最高金额
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = nums[0];
        for (int i = 3; i <= nums.length; i++) {
            // 计算前两次和前三次与其本身相加后的最高金额
            dp[i] = Math.max(dp[i-2]+nums[i-2], dp[i-3] + nums[i-3]);
        }
        // 返回整体的最大金额和nums最后一个数与它之前的最高金额相加后的最大金额
        return Math.max(dp[nums.length], dp[nums.length-1]+nums[nums.length-1]);
    }

    public  void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}

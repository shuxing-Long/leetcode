package Code06_DynamicPogramming;

public class Code746_minCostClimbingStairs {
    // 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
    //你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
    //请你计算并返回达到楼梯顶部的最低花费。
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0], cost[1]);
        // 记录每一步的最小花费
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= cost.length; i++){
            // 取前一步或前两步的最小
            dp[i] = Math.min(dp[i-2]+ cost[i-2], dp[i-1]+ cost[i-1]);
        }

        return dp[cost.length];
    }
}

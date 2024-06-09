package Code06_DynamicPogramming;

public class Code740_deleteAndEarn {

    // 给你一个整数数组 nums ，你可以对它进行一些操作。
    //每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
    //开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) {
            if(nums[0]+1 == nums[1] || nums[0]-1 == nums[1]) {
                return nums[0];
            }else {
                return nums[1]+nums[0];
            }
        }

        int maxV=0;
        for(int i = 0; i < nums.length; i++) {
            maxV = Math.max(maxV, nums[i]);
        }
        // 先将每个数查询的次数统计起来
        int[] countnums = new int[maxV+1];
        for(int num : nums) {
            countnums[num]+=num;
        }

        int[] dp = new int[maxV+1];
        dp[0] = countnums[0];
        dp[1] = Math.max(countnums[0], countnums[1]);
        for(int i = 2;i < countnums.length;i++) {
            // 判断 前一个数大还是当前数与前两位的最大数之和
            // 前两位的最大数是指不与当前数相邻数所能构成的最大数
            dp[i] = Math.max(dp[i-2] + countnums[i],dp[i-1]);
        }
        return Math.max(dp[dp.length-1],dp[dp.length-2]);
    }

    public  void main(String[] args) {
System.out.println(deleteAndEarn(new int[]{1,6,3,3,8,4,8,10,1,3}));    }
}

package Code06_DynamicPogramming;

public class Code673_findNumberOfLIS {
    //给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
    //注意 这个数列必须是 严格 递增的。
    public static int findNumberOfLIS(int[] nums) {
        if (nums.length == 1) return 1;

        // dp[i] 是当前的最长子序列
        int[] dp = new int[nums.length];
        // dp[i] 是当前的最长子序列的个数
        int[] cut = new int[nums.length];

        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            cut[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        // 当重新找到最长子序列时，小于将次数更换成当前最长子序列长度重新的次数
                        cut[i] = cut[j];
                    }else if(dp[j] + 1 == dp[i]){
                        // 当找到相同的子序列长度时，着加上j位置的子序列长度出现的次数
                        cut[i] += cut[j];
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
                count = cut[i];
            }else if(dp[i] == max){
                count += cut[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        System.out.println(findNumberOfLIS(new int[]{3,1,2}));
//        System.out.println(findNumberOfLIS(new int[]{2,2,2,2,2}));
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
    }
}

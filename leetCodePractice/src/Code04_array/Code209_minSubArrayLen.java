package Code04_array;

public class Code209_minSubArrayLen {
    // 给定一个含有 n 个正整数的数组和一个正整数 target 。
    //找出该数组中满足其总和大于等于 target 的长度最小的
    //子数组
    // [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    public static int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            // 如果找到和 target 一样的数则直接返回1
            if(nums[left] == target && nums[right] == target) {
                return 1;
            }
            sum +=  nums[right];
            while (sum >= target) {
                len = Math.min(len, right - left+1);
                sum -=  nums[left++];
            }
        }
        return len == Integer.MAX_VALUE?0:len;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
}

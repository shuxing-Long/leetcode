package Code05_greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code1403_minSubsequence {

    // 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
    //
    //如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
    //
    //与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
    //
    //注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length == 1){
            list.add(nums[0]);
            return list;
        }
        int max = 0;
        // 这里可以改成用数组统计，可免去排序的时间
        Arrays.sort(nums);
        // 先将所有数加起来
        for (int i = nums.length - 1; i >= 0; i--) {
            max += nums[i];
        }
        int s = 0;
        // 循环判断当返回的子序列大于其他数之和则退出返回
        for (int i = nums.length - 1; i >= 0; i--) {
            if(s <= max){
                list.add(nums[i]);
            }else {
                break;
            }
            max -= nums[i];
            s += nums[i];
        }
        return list;
    }

    public void main(String[] args) {
        minSubsequence(new int[]{4,4,7,6,7});
    }
}

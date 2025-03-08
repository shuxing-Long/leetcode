package Code01_Sort;

import java.util.LinkedList;
import java.util.List;

public class Code349_intersection {
    /*
    * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
    *
    * 示例 1：
        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2]
      示例 2：
        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[9,4]
        解释：[4,9] 也是可通过的
    * */
    public int[] intersection(int[] nums1, int[] nums2){
        if(nums1.length < 1){
            return nums1;
        }
        if (nums2.length < 1){
            return nums2;
        }
        List<Integer> nums5 = new LinkedList<>();
        int[] nums3 = new int[1001];
        for (int a =0; a<nums3.length;a++){
            nums3[a] = -1;
        }

        for (int i = 0;i<nums1.length;i++){
            for (int j = 0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    if(nums3[nums1[i]] == -1){
                        nums3[nums1[i]] = nums1[i];
                    }
                    break;
                }
            }
        }
        for (int s : nums3) {
            if(s!=-1){
                nums5.add(s);
            }
        }
        int[] nums6 = new int[nums5.size()];
        for (int k =0;k<nums5.size();k++){
            nums6[k] = nums5.get(k);
        }
        return nums6;
    }
}

package code01_Sort;

import java.util.LinkedList;
import java.util.List;

public class Code350_intersect {
    /*
    * 两个数组的交集 II
      给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
        示例 1：
        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2,2]
        示例 2:
        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[4,9]
     * */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < 1){
            return nums1;
        }
        if (nums2.length < 1){
            return nums2;
        }
        List<Integer> nums5 = new LinkedList<>();
        // 记录每个数字的交集数量
        int[] nums3 = new int[1001];
        int[] nums4 = new int[1001];
        int sum = Math.max(nums1.length,nums2.length);
        for (int a =0;a<sum;a++){
            if(a < nums1.length){
                nums3[nums1[a]]++;
            }
            if(a < nums2.length){
                nums4[nums2[a]]++;
            }
        }
        for (int j = 0;j<nums1.length;j++){
            if(nums3[nums1[j]]!=0&&nums4[nums1[j]]!=0){
                sum = Math.min(nums3[nums1[j]],nums4[nums1[j]]);
                for (int k =0;k<sum;k++){
                    nums5.add(nums1[j]);
                }
                nums3[nums1[j]]=0;
            }
        }
        int[] nums6 = new int[nums5.size()];
        for (int i=0;i< nums5.size();i++) {
            nums6[i] = nums5.get(i);
        }
        return nums6;
    }
}

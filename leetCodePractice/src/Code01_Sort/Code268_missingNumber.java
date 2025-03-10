package Code01_Sort;

public class Code268_missingNumber {
    /*
    *给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
    示例 1：
    输入：nums = [3,0,1]
    输出：2
    解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
    示例 2：
    输入：nums = [0,1]
    输出：2
    解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
    示例 3：
    输入：nums = [9,6,4,2,3,5,7,0,1]
    输出：8
    解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
    示例 4：
    输入：nums = [0]
    输出：1
    解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
    * */
    public int missingNumber(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0){
                return nums.length;
            }else {
                return 0;
            }
        }

        int[] nums2 = nums.clone();
        for (int i =0;i<nums.length;i++) {
            if(nums[i] < nums.length){
                nums2[nums[i]] = nums[i];
            }

        }
        int num1 = -1;
        for (int j = 0 ; j < nums2.length;j++){
            if(nums2[j] != j ){
                num1 = j;
                break;
            }
        }
        num1 = num1 == -1 ? nums.length:num1;
        return num1;
    }
}

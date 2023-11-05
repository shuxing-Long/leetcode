package code01_Sort;

public class Code414_thirdMax {
    // 查找第三大的数
    public static int thirdMax(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        // 受启发的写法
        long max = Long.MIN_VALUE,cen=Long.MIN_VALUE,min=Long.MIN_VALUE;
        for (long i : nums){
            if(i>max){
                min=cen;
                cen=max;
                max=i;
            } else if (max>i&&i>cen) {
                min=cen;
                cen=i;
            } else if (max>i&&cen>i&&i>min) {
                min=i;
            }
        }
        return min== Long.MIN_VALUE ?(int)max:(int)min;
        // 自己想的解法
//        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
//        int min=0;
//        for (int i=0;i<nums.length;i++){
//            max1 = Math.max(nums[i],max1);
//        }
//        for (int i=0;i<nums.length;i++){
//            if (nums[i] < max1) max2 = Math.max(nums[i],max2);
//        }
//        for (int i=0;i<nums.length;i++){
//            if (nums[i] < max2){
//                min++;
//                max3 = Math.max(nums[i],max3);
//            }
//            if(i==nums.length-1 && min==0) max3 = nums[i];
//        }
//        if(max1==max2 || max1==max3 || max2==max3){
//            max3 = Math.max(max3,max1);
//            return  Math.max(max3,max2);
//        }
//        return  max3;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,-2147483648,2};
        System.out.println(Code414_thirdMax.thirdMax(nums));
    }
}

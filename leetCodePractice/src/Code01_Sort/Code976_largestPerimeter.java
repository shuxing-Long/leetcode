package Code01_Sort;

import java.util.Arrays;

public class Code976_largestPerimeter {
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=2;i--){
            if(nums[i]<(nums[i-1]+nums[i-2])){
                return nums[i]+nums[i-1]+nums[i-2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3,2,3,4}));
    }
}

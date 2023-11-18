package code01_Sort;

public class Code747_dominantIndex {
    public static int dominantIndex(int[] nums) {
        if(nums.length==2){
            int max=Math.max(nums[0],nums[1]);
            int min =max==nums[0]?nums[1]:nums[0];
            int index = max==nums[0]?0:1;
            return (max/2)>=min?index:-1;
        }
        int ret =-1;
        int max = -1;
        int min = -1;
        for (int i=0;i<nums.length;i++){
            if(nums[i]>max){
                min = max;
                max=nums[i];
                ret = i;
            } else if (nums[i]<=max&&nums[i]>min) {
                min=nums[i];
            }
        }
        return (max/2)>=min?ret:-1;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{1,2,3,4}));
    }
}

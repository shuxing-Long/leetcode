package Code01_Sort;

import java.util.Arrays;

public class Code645_findErrorNums {
    public static int[] findErrorNums(int[] nums) {
        if(nums.length==2){
            return nums[0]==1?new int[]{1,2}:new int[]{2,1};
        }
         Arrays.sort(nums);
        // a是重复值，b是丢失值
        int a=0,b=0;
        //HashSet<Integer> hashMap=new HashSet<>();
        int con2=nums[0];
        for (int i=0, j=1;j<nums.length;i++,j++){
            a^= nums[j];
            con2+=nums[j];
        }
        int con = (nums.length*(nums.length+1))/2;
        if(con>con2){
            b=a+(con-con2);
        }else {
            b=a-(con2-con);
        }
        return new int[]{a,b};
    }
    private static void show(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        show(findErrorNums(new int[]{1,2,2,4}));
    }

}

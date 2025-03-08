package Code01_Sort;

public class Code922_sortArrayByParityII {
    public static int[] sortArrayByParityII(int[] nums) {
        if(nums.length==2){
            if(nums[1]%2==0){
                sawp(nums,1,0);
            }
            return nums;
        }
        int o=0,j=1;
        int[] nums2 =new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                nums2[o] = nums[i];
                o+=2;
            }else {

                nums2[j] = nums[i];
                j+=2;
            }
        }
        return nums2;
    }
    public static void sawp(int[] arr,int l,int r){
        int t=arr[l];
        arr[l] =arr[r];
        arr[r] = t;
    }

    private static void show(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        show(sortArrayByParityII(new int[]{4,2,5,7}));
    }
}

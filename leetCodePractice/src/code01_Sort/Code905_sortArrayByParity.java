package code01_Sort;

public class Code905_sortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {
        if(nums.length<=1){
            return nums;
        }
        for(int i = 0,j=nums.length-1;i<j;){
            if(nums[i]%2==0){
                i++;
            }else {
                sawp(nums,i,j--);
            }
        }
        return nums;
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
        show(sortArrayByParity(new int[]{0,1,2,4}));
    }
}

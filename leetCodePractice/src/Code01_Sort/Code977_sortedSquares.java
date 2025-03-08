package Code01_Sort;

public class Code977_sortedSquares {
    public static int[] sortedSquares(int[] nums) {
        if(nums.length==1){
            nums[0]=nums[0]*nums[0];
            return nums;
        }
        int[] nums2 = new int[nums.length];
        if(nums[0]>=0){
            // 全是正数时
            for (int i =0;i<nums.length;i++){
                nums2[i] = nums[i]*nums[i];
            }
        } else if (nums[nums.length-1]<0) {
            // 全是负数时
            for (int i =nums.length-1,j=0;i>=0;i--,j++){
                nums2[j] = nums[i]*nums[i];
            }
        }else {
            // 有正有负时
            // 存储遇到负数前的第一个正数
            int indexL = -1;
            for (int i =0;i<nums.length;i++){
                if(nums[i]>=0&& indexL==-1){
                    indexL = i;
                }
                nums[i] = nums[i]*nums[i];
            }
            // 最后一个负数
            int indexR = indexL-1;
            int k=0;
            while (indexR>=0||indexL<nums.length){
                if(indexR < 0){
                    nums2[k++] = nums[indexL++];
                    continue;
                }
                if(indexL >= nums.length){
                    nums2[k++] = nums[indexR--];
                    continue;
                }
                if(nums[indexR] > nums[indexL]){
                    nums2[k++] = nums[indexL++];

                }else {
                    nums2[k++] = nums[indexR--];
                }
            }
        }
        return nums2;
    }
    private static void show(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        show(sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}

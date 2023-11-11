package code01_Sort;

public class Code561_arrayPairSum {

    /*
    *
    * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
        返回该 最大总和 。
        示例 1：
        输入：nums = [1,4,3,2]
        输出：4
        解释：所有可能的分法（忽略元素顺序）为：
        1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
        2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
        3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
        所以最大总和为 4
        示例 2：
        输入：nums = [6,2,6,5,1,2]
        输出：9
        解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
    * */

    public static int arrayPairSum(int[] nums) {
        if(nums.length == 2){
            return Math.min(nums[0],nums[1]);
        }
        quickSort(nums,0,nums.length-1);
        int sum=0;
        for (int i=0;i<=nums.length-1;i+=2){
            sum+=nums[i];
        }
        return sum;
    }
    // 交换
    public static void swap(int[] arr,int i,int j){
       int t = arr[i];
       arr[i] = arr[j];
       arr[j] = t;
    }
    // 快排3.0
    public static void quickSort(int[] arr,int l,int r){
        if(l<r){
            swap(arr,r,l+ (int)(Math.random()*(r-l+1)));
            int[] p = partition(arr,l,r);
            quickSort(arr,l,p[0]-1);
            quickSort(arr,p[1]+1,r);
        }

    }

    public static int[] partition(int[] arr,int l,int r){
        int le = l - 1;
        int mo = r;
        while (l<mo){
            if(arr[l]<arr[r]){
                swap(arr,++le,l++);
            } else if (arr[l]>arr[r]) {
                swap(arr,--mo,l);
            }else {
                l++;
            }
        }
        swap(arr,mo,r);
        return new int[]{le+1,mo};
    }


    public static void main(String[] args) {
        int[] sum={6,2,6,5,1,2};
        System.out.println(arrayPairSum(sum));
    }

}

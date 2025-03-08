package Code01_Sort;

public class Code628_maximumProduct {
    public static int maximumProduct(int[] nums) {
        if(nums.length==3){
            return nums[0]*nums[1]*nums[2];
        }
//        Arrays.sort(nums);

        // 最大的数
        int max1 = -1001;
        int max2 = -1001;
        int max3 = -1001;
        // 最小的数
        int min1 = 1001;
        int min2 = 1001;
        // 线性扫描
        for (int i =0;i<nums.length;i++){
            if(nums[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i]<=max1&&nums[i]>max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i]<=max2&&nums[i]>max3) {
                max3 = nums[i];
            }
            if(nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i]>=min1&&nums[i]<min2) {
                min2 = nums[i];
            }
        }

        /*
        情况一: 全部是负数
        情况二: 一个正数
        情况三: 有两个负数,但最小的负数大于第二大的正数
        */
        int max = -1001;
        max = Math.max(max,max1*max2*max3);
        max = Math.max(max,max1*min1*min2);
        return max;
    }
    // 交换
    public static void swap(int[] arr,int l, int r){
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
    // 快排
    public static void quickSort(int[] arr,int l,int r){
        if(l<r){
            swap(arr,r,l + (int)(Math.random()*(r-l+1)));
            int[] p =partition(arr,l,r);
            quickSort(arr,l,p[0]-1);
            quickSort(arr,p[0]+1,r);
        }
    }

    // 调整区域
    public static int[] partition(int[] arr,int l,int r){
        int le = l - 1;
        int mo = r;
        while ( l < mo){
            if(arr[l] < arr[r]){
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
        System.out.println(maximumProduct(new int[]{-100,-2,-3,1}));
    }
}

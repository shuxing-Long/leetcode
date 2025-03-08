package Code01_Sort;

import java.util.*;

public class Code15_threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<=3){
            if ((nums[0]==0&&nums[1]==0&&nums[2]==0) || (nums[0]+nums[1]+nums[2]==0)){
                List<List<Integer>> lists=new LinkedList<>();
                List<Integer> list1 = new LinkedList<>();
                list1.add(nums[0]);
                list1.add(nums[1]);
                list1.add(nums[2]);
                lists.add(list1);
                return lists;
            }
            if (nums[0]+nums[1]+nums[2]!=0){
                return new LinkedList<>();
            }
        }
        Arrays.sort(nums);
        if(nums[0]>=0 && nums[nums.length-1]<=0 && Arrays.stream(nums).sum()==0){
            List<List<Integer>> lists=new LinkedList<>();
            List<Integer> list1 = new LinkedList<>();
            list1.add(0);
            list1.add(0);
            list1.add(0);
            lists.add(list1);
            return lists;
        }
        List<List<Integer>> lists = new LinkedList<>();
        // 记录上一个i的数
        int frontNum = Integer.MIN_VALUE;
        int frontNumJ = Integer.MIN_VALUE;
        for (int i =0; i<nums.length;i++){
            // 第一个指针遇到非负数时退出
            if(nums[i]>0){
                break;
            }
            // 如果相同则不处理
            if(frontNum == nums[i] ){
                continue;
            }
            frontNum = nums[i];
            int index = nums.length - 1;
            for (int j =i+1;j < nums.length-1;j++){
                // 如果相同则不处理
                if(frontNumJ == nums[j]){
                    continue;
                }
                frontNumJ = nums[j];
                // 如果两个字相加小于零，则表示第三个数是一个正数
                int a1 = recursionBinarySearch(nums,-(nums[j]+nums[i]),j+1,index);
                if(a1!=-1){
                    List<Integer> list1 = new LinkedList<>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[a1]);
                    lists.add(list1);
                    index = a1-1;
                }
            }
        }
        return lists;
    }

    // 二分查找
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){
        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        int midddle = (low + high) / 2;
        if(arr[midddle] > key){
            // 比查找值大着查找值在左区域
            return recursionBinarySearch(arr,key,low,midddle -1);
        } else if (arr[midddle] < key) {
            // 比查找值小着查找值在右区域
            return recursionBinarySearch(arr,key,midddle + 1,high);
        }else {
            return midddle;
        }
    }

    public static void show(List<List<Integer>> lists){
        for(List<Integer> list : lists){
            for (Integer num : list){
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        show(threeSum(new int[]{4,4,3,-5,0,0,0,-2,3,-5,-5,0}));
    }
}

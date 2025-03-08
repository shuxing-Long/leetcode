package Code04_array;

public class Code4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0;
        // 为了减少缩小区间的次数，方便更快的找出中位数。
        // 要保证nums1 是较短的数组，然后直接在nums1中继续二分
        // 求中位数公式: （x+y+1）/2
        if(nums1.length > nums2.length)
        {
            int[] nums3 = nums1;
            nums1 = nums2;
            nums2= nums3;
        }

        int x = nums1.length, y = nums2.length;
        // 因为中位数的两边数量是对等的，所以第二个数组只需要取两个数组和的一半的位置就可以了
        int initz = (x + y + 1) / 2;
        // 定义两个区间,不断的二分缩小
        int l = 0;
        int r = x;

        // 每次都取中位线，而因为中位线的对角一定是大小关系，所以可以用这个关系来确定中位数在哪里
        // nums1[i-1] <= nums2[j] && nums1[i] >= nums2[j-1]
        // 当 l(l是默认加一的，所以会遇到r) == r 时退出循环
        while(l < r){
            // 确定本次区间，两个数组这次的中位线
            int i = (r + (r - l + 1)) / 2;
            int j = initz - i ;

            // 如果没找到, 对角线大小成立的,缩小范围继续取中位数
            if(nums1[i-1] > nums2[j])
            {
                // 如果第一个数组的左对角线大于第二个数组的右对角线，则证明中位线在第一个数组的左边
                r = i - 1;
            }else{ // 否则中位数在右边
                l = i;
            }
        }

        int i = l;
        int j = initz - i;
        int nums1Max = i == 0 ? Integer.MIN_VALUE : nums1[i-1]; // 第一个数组中位线的左边， 左边最大
        int nums1Min = i == x ? Integer.MAX_VALUE : nums1[i]; //  第一个数组中位线的右边，右边最小
        int nums2Max = j == 0 ? Integer.MIN_VALUE : nums2[j-1];  // 第二个数组中位线的左边，左边最大
        int nums2Min = j == y ? Integer.MAX_VALUE : nums2[j]; // 第二个数组中位线的右边，右边最小

        return (x+y)%2!=0 ? Math.max(nums1Max, nums2Max) : ((double)(Math.max(nums1Max, nums2Max)+Math.min(nums1Min, nums2Min)))/2;
    }
}

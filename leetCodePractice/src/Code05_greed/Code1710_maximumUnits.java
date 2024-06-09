package Code05_greed;

public class Code1710_maximumUnits {

    // 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
    //
    //numberOfBoxesi 是类型 i 的箱子的数量。
    //numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
    //整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
    //
    //返回卡车可以装载 单元 的 最大 总数。
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] nums = new int[1001];
        // 先将二维数组转为一维,下标是单元数量，存储的是箱数
        for (int[] box : boxTypes) {
            nums[box[1]] += box[0];
        }
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= 0) continue;
            if(truckSize > 0){
                sum += (i * (truckSize >= nums[i] ? nums[i] : truckSize));
                truckSize-=nums[i];
            }else {
                break;
            }
        }
        return sum;
    }

    public void main(String[] args) {
        maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10);
    }
}

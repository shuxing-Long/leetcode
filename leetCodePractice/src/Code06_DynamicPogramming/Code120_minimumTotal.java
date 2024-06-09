package Code06_DynamicPogramming;

import java.util.ArrayList;
import java.util.List;

public class Code120_minimumTotal {

    // 给定一个三角形 triangle ，找出自顶向下的最小路径和。
    //每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于
    // 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
    public int minimumTotal(List<List<Integer>> triangle) {
        if( triangle.size() == 1) {
            int min = Integer.MAX_VALUE;
            for(Integer row : triangle.getFirst()) {
                min = Math.min(min, row);
            }
            return min;
        }
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.getFirst().getFirst();
        dp[1][0] = dp[0][0] + triangle.get(1).getFirst();
        dp[1][1] = dp[0][0] + triangle.get(1).getLast();
        if(triangle.size() == 2) {
            return Math.min(dp[1][1], dp[1][0]);
        }
        int min = Integer.MAX_VALUE;
        // i是层数
        for(int i = 2; i < triangle.size(); i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                if(j==0){
                    dp[i][j] = dp[i-1][j]+triangle.get(i).get(j);
                }else if(j== triangle.get(i).size()-1){
                    dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j);
                }else {
                    dp[i][j] =Math.min(dp[i-1][j]+triangle.get(i).get(j) ,dp[i-1][j-1]+triangle.get(i).get(j));
                }
                if(i==triangle.size()-1){
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;
    }
    // 别人的写法
    //  public int minimumTotal(List<List<Integer>> triangle) {
    //        int[] dp = new int[triangle.get(triangle.size() - 1).size() + 1];
    //        return helper(triangle, 0, dp);
    //    }
    //
    //    public int helper(List<List<Integer>> triangle, int layer, int[] dp) {
    //        if (layer == triangle.size()) {
    //            return 0;
    //        }
    //
    //        helper(triangle, layer + 1, dp);
    //        List<Integer> list = triangle.get(layer);
    //        //  从最后一层开始向上进行处理
    //        for (int i = 0; i < list.size(); i ++) {
    //            int cur = list.get(i);
    //            // 将当前数与下一行中i和i+1位置中的最小值相加
    //            // 还没进行处理的dp[i]其实是下一行的值
    //            dp[i] = Math.min(dp[i], dp[i + 1]) + cur;
    //        }
    //
    //        return dp[0];
    //    }

    public void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        System.out.println(minimumTotal(triangle));
    }
}

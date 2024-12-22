package Code06_DynamicPogramming;

public class Code931_minFallingPathSum {

    // 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
    //下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列
    // （即位于正下方或者沿对角线向左或者向右的第一个元素）。
    // 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length == 1) return matrix[0][0];
        int min = Integer.MAX_VALUE;
        int rows =  matrix.length;
        for(int i=rows-2;i >=0 ; i--){
            for(int j= 0;j<matrix[0].length; j++){
                int temp = matrix[i+1][j];
                if(j!=0){
                    temp = Math.min(matrix[i+1][j-1], temp);
                }
                if(j!=matrix[0].length-1){
                    temp = Math.min(matrix[i+1][j+1], temp);
                }
                matrix[i][j]+=temp;
                if(i==0){
                    min = Math.min(min,matrix[i][j]);
                }
            }

        }
        return min;
    }

    // 动态规划的方法
    public int minFallingPathSum2(int[][] matrix) {
        if(matrix.length == 1) return matrix[0][0];
        // 从下向上处理
        int rows = matrix.length;
        int[][] dp = new int[rows][rows];
        int min = Integer.MAX_VALUE;
        for(int i = rows-1; i >=0; i--) {
            for(int j = 0; j < rows; j++) {
                if(i == rows -1){
                    dp[i][j] = matrix[i][j];
                } else if(j==0){
                    dp[i][j] = Math.min(matrix[i][j] + dp[i+1][j], matrix[i][j]+ dp[i+1][j+1]);
                }else if(j== rows-1){
                    dp[i][j] = Math.min(matrix[i][j] + dp[i+1][j], matrix[i][j]+ dp[i+1][j-1]);
                }else {
                    dp[i][j] =Math.min(Math.min(dp[i+1][j] + matrix[i][j], dp[i+1][j-1]+ matrix[i][j]), dp[i+1][j+1]+ matrix[i][j]);
                }
                if(i==0){
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;
    }

    //别人的方法;用递归的方式更快
    // public int minFallingPathSum(int[][] matrix) {
    //        int n = matrix.length;
    //        if (n == 1)
    //            return matrix[0][0];
    //        dfs(matrix, n - 1);
    //        int min = matrix[n - 1][0];
    //        for (int i = 1; i < n; i++) {
    //            if (min > matrix[n - 1][i])
    //                min = matrix[n - 1][i];
    //        }
    //
    //        return min;
    //    }
    //
    //    public void dfs(int[][] matrix, int i) {
    //        if (i < 0)
    //            return;
    //        dfs(matrix, i - 1);
    //        int len = matrix[0].length;
    //        if (i > 0) {
    //            for (int j = 0; j < len; j++) {
    //                int min = matrix[i - 1][j];
    //                if (j > 0) {
    //                    min = Math.min(min, matrix[i - 1][j - 1]);
    //                }
    //                if (j < len - 1) {
    //                    min = Math.min(min, matrix[i - 1][j + 1]);
    //                }
    //                matrix[i][j] = min + matrix[i][j];
    //            }
    //        }
    //    }

    public void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }
}

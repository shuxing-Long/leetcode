package Code06_DynamicPogramming;

public class Code64_minPathSum {

    // 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //说明：每次只能向下或者向右移动一步。
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        // 如果是边界着向上或向左加，如果不是则选择左和右的数与当前数相加
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    // 别人的写法
    // public int minPathSum(int[][] grid) {
    //        int m = grid.length, n = grid[0].length;
    //        int dp[][] = new int[m][n];
    //        return find(grid, m - 1, n - 1, dp);
    //    }
    //    public static int find(int[][] grid, int m, int n, int dp[][]) {
    //        if (m == 0 && n == 0)    return grid[m][n];
    //        else if (m < 0 || n < 0)    return Integer.MAX_VALUE;
    //        else if (dp[m][n] != 0)    return dp[m][n];
    //        return dp[m][n] = grid[m][n] + Math.min(find(grid, m - 1, n, dp), find(grid, m, n - 1, dp));
    //    }

    public void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}

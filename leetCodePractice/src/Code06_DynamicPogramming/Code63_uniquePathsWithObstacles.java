package Code06_DynamicPogramming;

public class Code63_uniquePathsWithObstacles {

    // 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
    //现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
    //网格中的障碍物和空位置分别用 1 和 0 来表示。
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length ==1 || obstacleGrid[0].length ==1) {
            for (int i=0; i<obstacleGrid.length; i++) {
                for (int j=0; j<obstacleGrid[0].length; j++) {
                    if(obstacleGrid[i][j]==1) {
                        return 0;
                    }
                }
            }
            return 1;
        }

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<obstacleGrid.length; i++) {
            for(int j=0; j<obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j]==1) {
                    dp[i][j] = 0;
                }else {
                    if(i==0 && j==0) {
                        dp[i][j] = 1;
                    }else if(i == 0){
                        dp[i][j] = dp[i][j-1];
                    }else if(j == 0){
                        dp[i][j] = dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}

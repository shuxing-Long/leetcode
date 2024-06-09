package Code06_DynamicPogramming;

public class Code62_uniquePaths {
    // 不同路径
    // 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    //问总共有多少条不同的路径？
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        // 动态规划的方法
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];

        // return zhsx(m,n);
    }


    // 使用组合数学的方式解题
    public int zhsx(int m, int n) {
        // 分析：已知机器人每次只能向下或向右移动一个。而机器人始终在左上角，而终点在右下角，也就是对角线
        // (1) 因为终点是固定的，格子也是固定的，所以机器人移动的格数是固定的
        // (2) 机器人固定向下移动 m - 1 , 向右移动 n - 1 后到达终点
        // (3) 根据(2) 得 机器人总移动数是 ： m + n - 2
        // (4) 然后选择 m - 1 来做组合得方案数
        return (int) C(m,n);
    }
    // 求组合数
    public long C(int m, int n) {
        long res = 1;
        // 为了防止内存溢出，分子和分母从最小开始计算
        for (int i = 1; i < m; i++) {
            // res *=  n / i; 这样写是先除再乘
            res *=  n ;
            res /= i;
            n++;
        }
        return  res;
    }
    // 求排序数
    public long A(int m, int n) {
        long res = 1;
        for (int i = n; i >=1; i--) {
            res *= m;
            m--;
        }
        return res;
    }

    public  void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}

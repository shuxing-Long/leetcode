package Code06_DynamicPogramming;

public class Code712_minimumDeleteSum {
    // 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
    public static int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        // 初始化: dp[i][0]和dp[0][j] 分别是当前字符前的所有字符的ASCLL的总和
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }
        // 当s1.charAt(i - 1)字符和s2.charAt(i - 1)字符相等时
        // 则证明不需要删除字符，直接等于dp[i - 1][j - 1]就行
        // 反之,则选择删除s1和s2之间的最小值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j]+ s1.charAt(i - 1) , dp[i][j - 1]+ s2.charAt(j - 1));;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        minimumDeleteSum("delete","leet");
    }
}

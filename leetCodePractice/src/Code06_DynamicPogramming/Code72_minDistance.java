package Code06_DynamicPogramming;

public class Code72_minDistance {

    //     给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
    //     你可以对一个单词进行如下三种操作：
    //     插入一个字符
    //     删除一个字符
    //     替换一个字符
    //     没理解
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        if(n * m == 0) return word1.length() + word2.length();

        int[][] dp = new int[n + 1][m + 1];
        // 初始化dp, i边和j边分别是当前字符的位置操作所需要的最大次数
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        // 如果word1.charAt(i - 1) 和 word2.charAt(j - 1)不相等
        // 则dp[i - 1][j - 1]操作数加一，然后取插入(dp[i][j - 1])和删除dp[i - 1][j]和相同dp[i - 1][j - 1]之间的最小值。
        // 反之，则直接取插入(dp[i][j - 1])和删除dp[i - 1][j]和相同dp[i - 1][j - 1]之间的最小值。
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int d = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    d += 1;
                }
                dp[i][j] =Math.min(d,Math.min(dp[i - 1][j]+ 1, dp[i][j - 1]+ 1) );
            }
        }
        return dp[n][m];
    }
}

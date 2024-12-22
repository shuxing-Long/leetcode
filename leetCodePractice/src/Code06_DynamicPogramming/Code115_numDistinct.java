package Code06_DynamicPogramming;

public class Code115_numDistinct {
    // 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // dp[i][j] 代表 i-1 中 s 存在多少个 j-1 中 t 的个数
        // i 是 s 字符串下标
        // j 是 t 字符串下标
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag","bag"));
    }
}

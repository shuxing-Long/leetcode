package Code06_DynamicPogramming;

public class Code516_longestPalindromeSubseq {

    // 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
    //子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 1) return 1;

        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];

        for(int i = 0; i < chars.length; i++){
            dp[i][i] = 1;
        }
        // 如果chars[i] == chars[j]， 则去i+1 到 j-1 之间的最大值，因为是从内向外取，所以dp[0][chars.length-1]是最外层的值，也就是最大值
        for(int len = 2; len <= chars.length; len++){
            for(int i = 0; i <= chars.length - len; i++){
                int j = i + len - 1;
                if(chars[i] == chars[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][chars.length-1];
    }

    // 别人的写法
    public int longestPalindromeSubseq1(String s) {
        char[] c = s.toCharArray();
        int[] dp = new int[c.length];
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            int curMax = 0;
            // 从里向外处理
            for (int j = i - 1; j >= 0; j--) {
                // 记录上一层的数量
                int prev = dp[j];
                if (c[i] == c[j])
                    // 如果相等，着上一层的最长子序列加2
                    dp[j] = curMax + 2;
                // 记录上一层内的最长子序列
                curMax = Math.max(prev, curMax);
            }
        }
        for (int n : dp) {
            max = Math.max(max, n);
        }
        return max;

    }

    public void main(String[] args) {
        System.out.println(longestPalindromeSubseq1("abbc"));
    }
}

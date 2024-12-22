package Code06_DynamicPogramming;

public class Code5_longestPalindrome {

    // 最长回文子串
    // 写这道题时，我偷懒了。没有去已经自己对这道题的第一想法。从中间开始向两边进行查找。
    // 希望我可以改掉懒于思考的习惯
    // 如果感到疲惫，就去休息，不然大脑会偷懒
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;

        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        int l = 0;
        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] != chars[j]) {
                    dp[j][i] = false;
                }else {
                    if (i-j<3){
                        dp[j][i] = true;
                    }else {
                        dp[j][i] = dp[j+1][i-1];
                    }
                }

                if(dp[j][i] && i-j + 1 > maxLength){
                    maxLength = i-j+1;
                    l = j;
                }
            }
        }
        return s.substring(l,l+maxLength);
    }

}

package Code05_greed;

public class Code409_longestPalindrome {
    public int longestPalindrome(String s) {
        if(s.length() == 1) return 1;

        char[] chars = s.toCharArray();

        // 存储每个字符出现的次数
        int[] dp = new int[100];

        // 最大奇数次
        int max = -1;
        // 构成回文数的长度
        int res = 0;
        // 统计字符出现的次数
        for (int i = 0; i < chars.length; i++) {
            dp[chars[i] - 'A']++;
        }
        // 查找最大奇数和统计出现偶数次的和
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > max && dp[i]%2 != 0) max = i;
            if(dp[i] % 2 == 0) res += dp[i];
        }
        // 统计使用不是最大奇数次并且出现次数大于大于3的奇数，将这个奇数减一后，加到回文数长度上
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] % 2 != 0 && i != max && dp[i]>=3) res += dp[i]-1;
        }
        return max==-1?res:res+dp[max];
    }

    //================================================================================================
    // 别人的写法
    public int longestPalindrome1(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            // 这个可以将奇数变为减一后的偶数
            ans += v / 2 * 2;
            // 如果当前出现次数是奇数并且没有添加过一个奇数，则加一
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }



    public  void main(String[] args) {
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}

package Code05_greed;

public class Code680_validPalindrome {

    // 给你一个字符串 s，最多 可以从中删除一个字符。
    //请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
    public boolean validPalindrome(String s) {
        return validPalindrome2(s,0,s.length()-1,true);
    }

    public boolean validPalindrome2(String s, int l, int r,boolean isPalindrome) {
        if(s.length() == 1) return true;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if(!isPalindrome) return false;
                // isPalindrome是原来判断是否已经出现不同的情况
                isPalindrome = false;
                return validPalindrome2(s, l + 1, r, isPalindrome) || validPalindrome2(s, l, r - 1, isPalindrome);
            }
            l++;
            r--;
        }
        return true;
    }

    public  void main(String[] args) {
        System.out.println(validPalindrome("aba"));
    }
}

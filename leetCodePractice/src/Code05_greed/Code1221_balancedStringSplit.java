package Code05_greed;

public class Code1221_balancedStringSplit {

    // 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
    //给你一个平衡字符串 s，请你将它分割成尽可能多的子字符串，并满足：
    //每个子字符串都是平衡字符串。
    //返回可以通过分割得到的平衡字符串的 最大数量 。
    public int balancedStringSplit(String s) {
        if(s.length() == 2) return s.charAt(0) == s.charAt(1) ? 1 : 0;

        int r = 0;
        int l = 0;
        int count = 0;
        // 当r等于l时，就切割一次
        for(char c : s.toCharArray()) {
            if(c == 'R') r++;
            else l++;

            if(r == l && r != 0 && l != 0){
                count++;
                r = 0;
                l = 0;
            }
        }
        return count;
    }

    public void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }
}

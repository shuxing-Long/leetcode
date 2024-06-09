package Code05_greed;

public class Code1323_maximum69Number {

    // 给你一个仅由数字 6 和 9 组成的正整数 num。
    //
    //你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
    //
    //请返回你可以得到的最大数字。
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '6') {
                str = str.substring(0, i )+ "9" + str.substring(i + 1);
                return Integer.parseInt(str);
            }
        }
        return num;
    }

    // ======================================================================================
    // 别人写的
    // 只有拆装箱的方式更快
    public int maximum69Number1 (int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        String ans = new String(chars);
        return Integer.parseInt(ans);
    }
}

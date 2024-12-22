package Code04_array;

public class Code13_romanToInt {

    // 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    //字符          数值
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int max = toInt(chars[chars.length - 1]);
        for (int i = chars.length - 1; i >=0; i--) {
            int j = toInt(chars[i]);
            if(max > j){
                res -=j;
            }else {
                res += j;
            }
            max = j;
        }
        return res;
    }

    public int toInt(char s) {
        int res = 0;
        switch (s){
            case 'I':
                res =  1;
            break;
            case 'V':
                res =  5;
            break;
            case 'X':
                res =  10;
            break;
            case 'L':
                res =  50;
            break;
            case 'C':
                res =  100;
            break;
            case 'D':
                res =  500;
            break;
            case 'M':
                res =  1000;
            break;
        }
        return res;
    }

    public void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}

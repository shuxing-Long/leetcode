package Code05_greed;

public class Code1736_maximumTime {

    // 给你一个字符串 time ，格式为  hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
    //
    //有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
    //
    //替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();

        if(chars[0] == '?'){
            chars[0] = (chars[1] > '3'  && chars[1] != '?')  ? '1':'2';
        }

        if(chars[1] == '?'){
            chars[1] = chars[0] == '2'?'3':'9';
        }

        if(chars[3] == '?'){
            chars[3] = '5';
        }

        if(chars[4] == '?'){
            chars[4] = '9';
        }

        return new String(chars);
    }
}

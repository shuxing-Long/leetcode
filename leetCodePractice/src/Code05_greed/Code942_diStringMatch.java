package Code05_greed;

public class Code942_diStringMatch {
    //由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
    //
    //如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
    //如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
    //给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
    public int[] diStringMatch(String s) {
        if(s.length() == 0) return s.charAt(0)=='D'? new int[]{1,0} : new int[]{0,1};

        int l = 0;
        int r = s.length();
        int[] res = new int[s.length()+1];

        for(int i=0;i < s.length();i++){
            if(s.charAt(i)=='D') res[i] = r--;
            else res[i] =l++;
        }
        res[res.length-1] = s.charAt(s.length()-1) == 'D'? r--:l++;
        return res;
    }

    public void main(String[] args) {
        diStringMatch("IDID");
    }
}

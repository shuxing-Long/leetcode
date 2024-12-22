package Code06_DynamicPogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Code139_wordBreak {

    // 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
    //注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 判断每一个范围内是否有符合的字符串
                // 判断前一个字符是否是合法(在wordDict中存在的字符)的字符
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean iswordBreak(String s, List<String> wordDict) {
        for (int j = 0; j < wordDict.size(); j++) {
            if(s.equals(wordDict.get(j))){
                return true;
            }
        }
        return false;
    }

    // 别人的写法
     public boolean wordBreak1(String s, List<String> wordDict) {
            Boolean[] flag = new Boolean[s.length() + 1];
            return wordDict(s, 0, wordDict, flag);
        }

        private boolean wordDict(String s, int start, List<String> wordDict, Boolean[] flag) {
            if(flag[start] != null) return flag[start];
            if(start == s.length()) return true;
            for(String word: wordDict){
                // 检查字符串s是否以指定的word开头，可以从指定的索引start开始进行比较。
                if(s.startsWith(word,start)){
                    boolean res = wordDict(s,start+word.length(),wordDict,flag);
                    if(res) return true;
                }
            }
            flag[start] = false;
            return false;
        }



    public  void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak1("leetcode", list);
    }


}

package code01_Sort;

public class Code506_findRelativeRanks {
    /*
    * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
    运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
    名次第 1 的运动员获金牌 "Gold Medal" 。
    名次第 2 的运动员获银牌 "Silver Medal" 。
    名次第 3 的运动员获铜牌 "Bronze Medal" 。
    从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
    使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
    * */
    public static String[] findRelativeRanks(int[] score) {

        return null;
    }

    public static void main(String[] args) {
        int[] g = new int[]{10,9,8,7};

        System.out.println(findRelativeRanks(g));
        show(g);
    }



    private static boolean less(int v,int w){
        return (v-w) < 0;
    }

    private static void exch(int[] a,int i,int j){
        int t =a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static boolean isSorted(int[] a){
        for (int i = 1;i<a.length;i++){
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }
}

package Code01_Sort;

import java.util.HashMap;

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
        if(score.length == 1){
            return new String[]{"Gold Medal"};
        }
        if(score.length == 2){
            if(score[0]> score[1]){
                return new String[]{"Gold Medal","Silver Medal"};
            }
            return new String[]{"Silver Medal","Gold Medal"};
        }
        // 记录数字的排名
        HashMap<Integer,Integer> mapArr = new HashMap<>();
        int[] score2 = score.clone();
        String[] strs=new String[score.length];
        quickSort(score,0,score.length - 1);
        for (int i=0;i<score.length;i++){
            mapArr.put(score[i],i);
        }
        for (int j=0;j<score2.length;j++){
            strs[j] = exchStr(mapArr.get(score2[j]));
        }
        /*System.out.println("+++++结束");
        show1(score);*/
        return strs;
    }
    public static void quickSort(int[] arr,int L,int R){
        if(L < R){
            exch(arr,R,L + (int)(Math.random()*(R - L + 1)));
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }

    // 将范围内的数整理成左为大于区域，中间是等于区域，右边是小于区域
    public static int[] partition(int[] arr,int L,int R){
        int less = L-1; // < 区右边界
        int more = R;  // > 区左边界
        while (L < more) {
            if (arr[L] > arr[R]) {
                exch(arr, ++less, L++);
            } else if (arr[L] < arr[R]) {
                exch(arr, --more, L);
            } else {
                L++;
            }
        }
        exch(arr,less+1,R);
        return new int[]{less+1, more};
    }
    // 交换
    private static void exch(int[] a,int i,int j){
        int t =a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static String exchStr(int i){
        String str = ""+(i+1)+"";
        switch (i){
            case 0:
                str = "Gold Medal";
            break;
            case 1:
                str = "Silver Medal";
                break;
            case 2:
                str = "Bronze Medal";
                break;
        }
        return str;
    }


    public static void main(String[] args) {
        int[] g = new int[]{10,3,8,9,4};

        show(findRelativeRanks(g));
    }
    private static void show(String[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    private static void show1(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static boolean less(int v,int w){
        return (v-w) < 0;
    }



    private static boolean isSorted(int[] a){
        for (int i = 1;i<a.length;i++){
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }
}

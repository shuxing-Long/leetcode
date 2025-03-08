package Code01_Sort;

import java.util.*;

public class Code1200_minimumAbsDifference {

    // 1200. 最小绝对差
    // 给你个整数数组 arr，其中每个元素都 不相同。
    //请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
    //每对元素对 [a,b] 如下：
    //a , b 均为数组 arr 中的元素
    //a < b
    //b - a 等于 arr 中任意两个元素的最小绝对差
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        // 排序
        Arrays.sort(arr);
        int least = Integer.MAX_VALUE;
        // 查找最小绝对差
        for (int i=0,j=1;j<arr.length;j++,i++){
            int c = arr[j]-arr[i];
            least = Math.min(least,c);
        }
        List<List<Integer>> lists = new LinkedList<>();
        for (int i=0,j=1;j<arr.length;j++,i++){
            if((arr[j]-arr[i])==least){
                List<Integer> list = new LinkedList<>();
                list.add(arr[i]);
                list.add(arr[j]);
                lists.add(list);
            }
        }
        return lists;
    }
    private static void show(List<List<Integer>> a){
        for (List<Integer> l : a){
            System.out.print("["+l.get(0)+","+l.get(1)+"]");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        show(minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27}));
    }
}

package Code01_Sort;

import java.util.Arrays;
import java.util.HashSet;

public class Code888_fairCandySwap {
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        HashSet<Integer> hashSet =new HashSet<>();

        // 两个数字的相差值
        int ca =(Arrays.stream(aliceSizes).sum() - Arrays.stream(bobSizes).sum()) / 2;
        for(int i : aliceSizes){
            hashSet.add(i);
        }
        for (int j : bobSizes){
            if( hashSet.contains(j+ca)){
                return new int[]{j+ca,j};
            }

        }
        return new int[]{0,0};
    }
    private static void show(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        show(fairCandySwap(new int[]{1,1},new int[]{2,2}));
    }
}

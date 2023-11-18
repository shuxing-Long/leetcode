package code01_Sort;

import java.util.HashMap;

public class Code976_largestPerimeter {
    public static int largestPerimeter(int[] nums) {
        HashMap<Integer,Integer> hashMap =new HashMap<>();
        int max=0;
        for (int i:nums) {
            if(hashMap.containsKey(i)){
                hashMap.put(i,hashMap.get(i)+1);
            }else {
                hashMap.put(i,1); 
            }
        }
        for (int i:nums) {
            if(hashMap.containsKey(i+1)){
                if(hashMap.get(i+1)>=2){
                    max = Math.max(max,i+((i+1)*2));
                }
            }
            if(hashMap.containsKey(i-1)){
                if(hashMap.get(i-1)>=2){
                    max = Math.max(max,i+((i-1)*2));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3,2,3,4}));
    }
}

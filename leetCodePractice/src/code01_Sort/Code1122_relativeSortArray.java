package code01_Sort;

public class Code1122_relativeSortArray {
    //1122. 数组的相对排序
    //给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
    //对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 存储arr1 中每个数字出现的数量
        int[] arr3 = new int[1001];
        int[] arr4 = new int[arr1.length];
        for (int i =0;i<arr1.length;i++){
            arr3[arr1[i]]++;
        }
        int sum =0;
        for (int i =0;i<arr2.length;i++){
            for (int j=0;j< arr3[arr2[i]];j++){
                arr4[j+sum]=arr2[i];
            }
            sum+=arr3[arr2[i]];
            arr3[arr2[i]]=0;
        }
        for (int i =0;i<arr3.length;i++){
            if(arr3[i]>0){
                for (int j=0;j<arr3[i];j++){
                    arr4[j+sum]=i;
                }
                sum+=arr3[i];
            }
        }
        return arr4;
    }
    private static void show(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        show(relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31},new int[]{2,42,38,0,43,21}));
    }
}

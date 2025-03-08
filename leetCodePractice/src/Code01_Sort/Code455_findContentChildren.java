package Code01_Sort;

public class Code455_findContentChildren {
    public static int findContentChildren(int[] g, int[] s) {
        if (s.length==0){
            return 0;
        }
        int gsum = 0;
        int ssum = 0;
        int sum=0;
        sort(g);
        sort(s);
        while (ssum < s.length && gsum < g.length){
            if(s[ssum] >= g[gsum]){
                sum++;
                gsum++;
            }
            ssum++;
        }
        return sum;
    }

    // 插入排序
    private static void sort(int[] arr){
        int N = arr.length;
        for (int i=1;i<N;i++){
            for (int j =i;j>0&&less(arr[j],arr[j-1]);j--){
                exch(arr,j,j-1);
            }
        }
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

    public static void main(String[] args) {
        int[] g = new int[]{10,9,8,7};
        int[] s = new int[]{5,6,7,8};

        System.out.println(findContentChildren(g,s));
        show(g);
    }
}

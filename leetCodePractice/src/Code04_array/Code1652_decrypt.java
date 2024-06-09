package Code04_array;

public class Code1652_decrypt {
    public static int[] decrypt(int[] code, int k) {
        int[] arr =new int[code.length];
        if(k==0){
            return arr;
        } else if (k>0) {
            for (int i=0;i< code.length;i++){
                for (int j=1;j<=k;j++){
                    arr[i]+=code[(i+j)% code.length];
                }
            }
        }else {
            for (int i=0;i< code.length;i++){
                for (int j=1;j<=-k;j++){
                    arr[i]+=code[((i-j)+ code.length)% code.length];
                }
            }
        }
        return arr;

        // 别人的想法
        /*int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] res = new int[n];
        int[] newCode = new int[n * 2];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        code = newCode;
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int w = 0;
        for (int i = l; i <= r; i++) {
            w += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = w;
            w -= code[l];
            w += code[r + 1];
            l++;
            r++;
        }
        return res;*/
    }

    public static void show(int[] arr){
        for (int a :arr){
            System.out.print(a+" ");
        }
    }

    public static void main(String[] args) {
        show(decrypt(new int[]{2,4,9,3},-2));
    }
}

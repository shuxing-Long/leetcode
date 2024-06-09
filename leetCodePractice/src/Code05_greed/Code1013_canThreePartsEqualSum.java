package Code05_greed;

public class Code1013_canThreePartsEqualSum {
    // 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
    //
    //形式上，如果可以找出索引 i + 1 < j 且满足
    // (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] ==
    // arr[j] + arr[j + 1] + ... + arr[arr.length - 1])
    // 就可以将数组三等分。
    public boolean canThreePartsEqualSum(int[] arr) {

        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum +=arr[i];
        }
        if(sum % 3 != 0) return false;
        sum = sum / 3;
        int s = 3;
        int z = 0;
        for (int i = 0; i < arr.length; i++) {
            if(s <=0) return true;
            z += arr[i];
            if(z == sum){
                s--;
                z = 0;
            }
        }
        return s==0;
    }

    public  void main(String[] args) {
        canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1});
    }
}

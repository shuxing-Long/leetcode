package Code06_DynamicPogramming;

public class Code221_maximalSquare {

    // 最大正方形
    // 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
    // 这样当前的位置的左边、上边和左上交的位置内容都是不是0，证明存在一个正方形
    // 如果这三个位置不是0，并且相同则证明可以与当前位置组成一个更大的正方形
    // 如果这三个位置不是0，并且互不相同则取一个最小值
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 1 && matrix[0].length == 1) {
            if(matrix[0][0] == '1') {
                return 1;
            }else{
                return 0;
            }
        }
        if(matrix.length == 1) {
            for(int i = 0; i < matrix[0].length; i++) {
                if(matrix[0][i] == '1') {
                    return 1;
                }
            }
            return 0;
        }
        if(matrix[0].length == 1) {
            for(int i = 0; i < matrix.length; i++) {
                if(matrix[i][0] == '1') {
                    return 1;
                }
            }
            return 0;
        }


        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == '1') {
                dp[0][i]=1;
                max=1;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == '1') {
                dp[i][0]=1;
                max=1;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] != '0' && matrix[i-1][j] != '0'&& matrix[i-1][j-1] != '0'&& matrix[i][j-1] != '0') {
                    dp[i][j] =Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1])) +1;

                }else {
                    if(matrix[i][j] == '1') {
                        dp[i][j]=1;
                    }
                }
                max=Math.max(dp[i][j],max);
            }
        }
        return max*max;
    }
    public void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'0','0','1','1','1'},
        }));
    }
}

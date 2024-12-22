package Code04_array;

public class Code59_generateMatrix {

    // 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
    // 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int indel = 1;
        int[][] bh = new int[n][n];

        while (left <= right && top <= bottom)
        {
            // 从左到右
            for (int i = left; i <= right; i++)
            {
                bh[top][i] = indel++;
            }
            top++;

            // 从上到下
            for (int i = top; i <= bottom; i++)
            {
                bh[i][ right] = indel++;
            }
            right--;

            //从右到左
            if (left<=right)
            {
                for (int i = right; i >= left; i--)
                {
                    bh[bottom][ i] = indel++;
                }
                bottom--;
            }

            //从下到上
            if (top <= bottom)
            {
                for (int i = bottom; i >= top; i--)
                {
                    bh[i][ left] = indel++;
                }
                left++;
            }
        }

        return bh;
    }
}

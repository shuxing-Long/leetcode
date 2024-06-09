package Code06_DynamicPogramming;

public class Code70_climbStairs {
    // 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int l = 0,c = 1,r=2;

        for (int i = 3; i <= n; i++) {
            l = c;
            c = r;
            r = l + c;
        }
        return r;
    }
}

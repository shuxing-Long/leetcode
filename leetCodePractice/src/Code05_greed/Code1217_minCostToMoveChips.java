package Code05_greed;

public class Code1217_minCostToMoveChips {

    // 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
    //
    //我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
    //
    //position[i] + 2 或 position[i] - 2 ，此时 cost = 0
    //position[i] + 1 或 position[i] - 1 ，此时 cost = 1
    //返回将所有筹码移动到同一位置上所需要的 最小代价 。
    public int minCostToMoveChips(int[] position) {
        if (position.length == 1) return 0;
        // 先查找移动的终点
        int j = 0;
        int o = 0;
        // 最省的方式是 n次 position[i] + 2 或 position[i] - 2 加一个 position[i] + 1 或 position[i] - 1
        // 然后再选择position中 奇数和偶数的出现次数，然后选择出现次数最小的返回
        for (int i = 0; i < position.length ; i++) {
            if (position[i]%2 == 1) j++;
            else o++;
        }

        return Math.min(j, o);
    }

    public void main(String[] args) {
        minCostToMoveChips(new int[]{2,2,2,3,3});
    }
}

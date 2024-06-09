package Code05_greed;

import java.sql.Array;
import java.util.Arrays;

public class Code860_lemonadeChange {
    // 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
    //
    //每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
    //
    //注意，一开始你手头没有任何零钱。
    //
    //给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
    public boolean lemonadeChange(int[] bills) {
        if(bills.length ==1) return bills[0]==5 ? true:false;



        int[] moneys = new int[3];

        for(int i=0 ;i< bills.length;i++){
            if(bills[i]==5){
                // 如果是5元则不需要找零
                moneys[0]++;
            }
            if(bills[i]==10){
                moneys[1]++;
                if(moneys[0]>=1){
                    moneys[0]--;
                }else {
                    return false;
                }
            }
            if(bills[i]==20) {
                moneys[2]++;
                if((moneys[0]>=1 && moneys[1]>=1) ){
                    moneys[0]--;
                    moneys[1]--;
                }else if(moneys[0]>=3){
                    moneys[0]-=3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,5,5,20,20,5,5,5,5}));
    }
}

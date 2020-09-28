/*
 * 三枚硬币
 * 初始状态：（反，正，反）
 *           （0，1，0）
 * 连续翻三枚硬币，能否使最终状态为（0，0，0）或（1，1，1）
 * 翻N次硬币
 * 算法设计：
1.为每一个算符定义一个功能函数，代表其具体的操作（改变当前硬币的状态：正面朝上 || 反面朝上）
2.使用循环完成N次测试
for(循环N次，代表N次测试）
{
   每一次测试进行三次翻动
   do{
     随机决定翻动哪一枚硬币
     调用相关函数，并记录翻动后3枚硬币的状态和每次翻动的硬币对象
   }while(<=3)

   比较三次翻动后的结果与目标状态是否匹配，可对所有翻动结果进行去重处理
   输出两个目标状态的达成条件（哪些翻动可以实现初始状态到目标状态的变化）
}*/

import java.util.ArrayList;
import java.util.List;

public class TurnCoins {
    public static void main(String[] args) {
        List<String> allFalse = new ArrayList<String>();
        List<String> allTrue = new ArrayList<String>();
        for (int n = 0; n < 20000; n++) {//做50次实验，每一次翻三次硬币，翻三次后是否达到000或111状态
            List<Integer> coins = new ArrayList<Integer>(3);
            /*硬币初始状态（0，1，0）（反，正，反）*/
            coins.add(0);
            coins.add(1);
            coins.add(0);
            int k = 0;     //局部变量k,表示翻动次数
            StringBuilder seq = new StringBuilder(); //记录每次实验翻哪一枚硬币
            do {
                int j = (int) (Math.random() * 100) % 3;//随机翻哪一枚硬币
                /*翻动第j枚硬币*/
                if (coins.get(j).equals(0)) {
                    coins.set(j, 1);
                } else if (coins.get(j).equals(1)) {
                    coins.set(j, 0);
                }
                k++;
                seq.append((j + 1));  //记录翻动的硬币，翻动一次记录一下
            } while (k < 3);//k=0\1\2 翻三次
            if (coins.get(0).equals(coins.get(1)) && coins.get(0).equals(coins.get(2)) && coins.get(0).equals(0)) {
                if (!allFalse.contains(seq.toString()))
                    allFalse.add(seq.toString());
            }
            if (coins.get(0).equals(coins.get(1)) && coins.get(0).equals(coins.get(2)) && coins.get(0).equals(1)) {
                if (!allTrue.contains(seq.toString()))
                    allTrue.add(seq.toString());
            }
        }
        if (allFalse.size() != 0) {
            System.out.println("到达（0，0，0）的翻转方法");
            for (String item : allFalse)
                System.out.println(item);
        }
        if (allTrue.size() != 0) {
            System.out.println("到达（1，1，1）的翻转方法");
            for (String item : allTrue)
                System.out.println(item);
        } else System.out.println("没有到达（1，1，1）的翻转方法");
    }
}


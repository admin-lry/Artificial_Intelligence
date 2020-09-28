package monkeypickbanana;

import static monkeypickbanana.Methods.*;

/**
 * @Description
 * @Author RuoYang
 * @Date 2020-09-28 20:11
 */
public class MonkeyPickBanana {
    public static void main(String[] args) {
        System.out.println("Please input the position of monkey, banana, box, using a,b,c ");

        Monkey monkey = new Monkey();
        Banana banana = new Banana();
        Box box = new Box();
        HoldBanana holdBanana = new HoldBanana();
        OnBox onBox = new OnBox();
        startInput(monkey, banana, box);
        System.out.println("The position of monkey, banana, box is showed as follow:");
        System.out.println("monkey: " + monkey.getLocation());
        System.out.println("banana: " + banana.getLocation());
        System.out.println("box:    " + box.getLocation());

        while (!holdBanana.getHoldBanana()) {//当猴子没有拿到香蕉时  做下一步动作
            //ShowStatus(monkey, banana, box, holdBanana, onBox);//输出当前状态
            doNext(monkey, banana, box, holdBanana, onBox);//做一个动作

        }
        ShowStatus(monkey, banana, box, holdBanana, onBox);//输出当前状态

    }}






package monkeypickbanana;

import java.util.Scanner;

/**
 * @Description
 * @Author RuoYang
 * @Date 2020-09-28 23:27
 */
public class Methods {
    static void startInput(Monkey monkey, Banana banana, Box box) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String monkeyInput = scanner.next();    //to input the location of monkey
            String bananaInput = scanner.next();    //to input the location of banana
            String boxInput = scanner.next();       //to input the location of box
            /* */
            if (monkeyInput.length() == 1 && bananaInput.length() == 1 && boxInput.length() == 1) {
                monkey.setLocation(monkeyInput);
                banana.setLocation(bananaInput);
                box.setLocation(boxInput);
                break;
            } else {
                System.out.println("Error! Must be 'a' ,'b' or 'c'.");

            }
        }
    }


    static void doNext(Monkey monkey, Banana banana, Box box, HoldBanana holdBanana, OnBox onBox) {

        if (!monkey.getLocation().equals(box.getLocation())) {

            ShowStatus(monkey, banana, box, holdBanana, onBox);
            go(monkey, box);

        }
        if (monkey.getLocation().equals(box.getLocation())) {
            ShowStatus(monkey, banana, box, holdBanana, onBox);
            move(monkey, box, banana);

        }
        if (samePlace(monkey, box, banana)) {
            ShowStatus(monkey, banana, box, holdBanana, onBox);
            climb(box, onBox);

        }
        if (samePlace(monkey, box, banana) && onBox.getOnBox()) {
            ShowStatus(monkey, banana, box, holdBanana, onBox);
            pick(banana, holdBanana);

        }
    }

    private static void go(Monkey monkey, Box box) {
        System.out.println("    ==>step1: go(" + monkey.getLocation() + "," + box.getLocation() + ")");
        monkey.setLocation(box.getLocation());
    }

    private static void move(Monkey monkey, Box box, Banana banana) {
        System.out.println("    ==>step2: move(" + box.getLocation() + "," + banana.getLocation() + ")");
        monkey.setLocation(banana.getLocation());
        box.setLocation(banana.getLocation());

    }

    private static void climb(Box box, OnBox onBox) {
        System.out.println("    ==>step3: climb(" + box.getLocation() + ")");
        onBox.setOnBox(true);
    }

    private static void pick(Banana banana, HoldBanana holdBanana) {
        System.out.println("    ==>step4: pick(" + banana.getLocation() + ")");
        holdBanana.setHoldBanana(true);
    }

    private static boolean samePlace(Monkey monkey, Box box, Banana banana) {
        return monkey.getLocation().equals(box.getLocation()) && box.getLocation().equals(banana.getLocation());
    }


    static void ShowStatus(Monkey monkey, Banana banana, Box box, HoldBanana holdBanana, OnBox onBox) {
        AT(monkey);
        AT(banana);
        AT(box);
        HOLD(holdBanana);
        ON(onBox);
    }

    public static void AT(Obj object) {
        //输出 AT(对象,位置)
        System.out.print("AT(" + object.getName() + "," + object.getLocation() + ")，");
    }

    private static void HOLD(HoldBanana holdBanana) {
        if (holdBanana.getHoldBanana())//如果拿到香蕉
            System.out.print("HOLD(banana)，");
        else        //没有拿到香蕉
            System.out.print("HOLD(empty)，");
    }

    public static void ON(OnBox onBox) {
        if (onBox.getOnBox())//如果爬上箱子
            System.out.println("ON(monkey)");
        else    //没有爬上箱子
            System.out.println("ON(empty)");
    }
}


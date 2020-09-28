import java.util.Scanner;

/**
 * @Description
 * @Author RuoYang
 * @Date 2020-09-28 19:46
 */
/*
 * 房子里有一只猴子（即机器人），位于a处。在c处上方的天花板上有一串香蕉，猴子想吃，但摘不到。
 * 房间的b处还有一个箱子，如果猴子站到箱子上，就可以摸着天花板。
 * 对于上述问题，可以通过谓词逻辑表示法来描述知识。
 * 要求通过VC语言编程实现猴子摘香蕉问题的求解过程。*/
public class MonkeyPickBanana {
    public static void main(String[] args) {
        Scene scene = new Scene();
        System.out.println("Please input the position of monkey, banana, box, using a,b,c ");
        String input;
        //input the location of the monkey,banana and box
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        char monkey = input.charAt(0);
        char banana = input.charAt(1);
        char box = input.charAt(2);
        //output the location of the monkey,banana and box that you have input
        System.out.println("The position of monkey, banana, box is showed as follow:");
        System.out.println("monkey: " + monkey);
        System.out.println("banana: " + banana);
        System.out.println("box:    " + box);
        //initiate
        scene.setMonkey(String.valueOf(monkey));
        scene.setBanana(String.valueOf(banana));
        scene.setBox(String.valueOf(box));
        scene.setOnBox(false);
        scene.setPicked(false);

        //如果monkey和box不在一个位置: go(monkey,box)
        if (!scene.getMonkey().equals(scene.getBox())) {
            go(scene, scene.getMonkey(), scene.getBox());
        }
        //如果monkey和box在一个位置：move(box,banana)
        if (scene.getMonkey().equals(scene.getBox())) {
            move(scene, scene.getBox(), scene.getBanana());
        }
        //如果monkey、box和banana在一个位置：climb(monkey,box)
        if (samePlace(scene)) {
            climb(scene, scene.getBox());
        }
        //如果monkey、box、banana在同一位置且monkey在box上：pick(monkey,banana)
        if (samePlace(scene) && scene.isOnBox()) {
            pick(scene, scene.getBanana());
        }
    }

    /*whether they are at the same place*/
    private static boolean samePlace(Scene scene) {
        return scene.getMonkey().equals(scene.getBox()) && scene.getMonkey().equals(scene.getBanana());
    }

    /*the monkey pick the banana*/
    private static void pick(Scene scene, String banana) {
        scene.setPicked(true);
        System.out.println("==>step4: pick(" + banana + ")");
    }

    /*the monkey climb the box*/
    private static void climb(Scene scene, String monkey) {
        scene.setOnBox(true);
        System.out.println("==>step3: climb(" + monkey + ")");
    }

    /*move the box from its location to that of banana */
    private static void move(Scene scene, String box, String banana) {
        scene.setBox(banana);
        scene.setMonkey(banana);
        System.out.println("==>step2: move(" + box + "," + banana + ")");
    }

    /*monkey go to box*/
    private static void go(Scene scene, String monkey, String box) {
        scene.setMonkey(box);
        System.out.println("==>step1: go(" + monkey + "," + box + ")");
    }
}

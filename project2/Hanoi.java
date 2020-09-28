import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入圆盘的个数：");
        int n=scanner.nextInt();
        hanoi(n, 'A', 'B', 'C');
    }

    public static void hanoi(int n, char A, char B, char C) {
        if (n == 1)                         //圆盘只有一个时，只需将其从A塔移到C塔
            move(1, A, C);               //将编b号为1的圆盘从A移到C
        else {
            hanoi(n - 1, A, C, B);      //递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            move(n, A, C);                 //把A塔上编号为n的圆盘移到C上
            hanoi(n - 1, B, A, C);      //递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
        }
    }

    private static void move(int i, char a, char c) {
        System.out.println("from " + a + " to " + c);
    }
}

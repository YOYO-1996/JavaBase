package hwinterview.inputTest;

import java.util.Scanner;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 11:20
 */
public class HWTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int i = 0; i < lines; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}

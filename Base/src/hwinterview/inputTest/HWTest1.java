package hwinterview.inputTest;

import java.util.Scanner;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15
 */
public class HWTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}

package hwinterview.inputTest;

import java.util.Scanner;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 11:20
 */
public class HWTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a != 0 && b != 0) {
                System.out.println(a + b);
            } else {
                break;
            }
        }
    }
}

package hwinterview.inputTest;

import java.util.Scanner;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 11:20
 */
public class HWTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int count = sc.nextInt();
            if (count == 0) {
                break;
            }
            int currSum = 0;
            for (int i = 0; i < count; i++) {
                int currInt = sc.nextInt();
                currSum += currInt;
            }
            System.out.println(currSum);
        }
    }
}

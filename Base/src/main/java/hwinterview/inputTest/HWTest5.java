package hwinterview.inputTest;

import java.util.Scanner;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 11:20
 */
public class HWTest5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int i = 0; i < lines; i++) {
            int count = sc.nextInt();
            int currSum = 0;
            for (int j = 0; j < count; j++) {
                int currInt = sc.nextInt();
                currSum += currInt;
            }
            System.out.println(currSum);
        }

    }
}

package hwinterview.NewCodeHW;

import java.util.Scanner;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 12:14
 */
public class IntReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currInt = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (currInt != 0) {
            int currChar = currInt % 10;
            sb.append(currChar);
            currInt /= 10;
        }
        System.out.println(sb.toString());
    }
}

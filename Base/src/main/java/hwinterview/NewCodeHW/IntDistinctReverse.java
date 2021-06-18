package hwinterview.NewCodeHW;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 12:14
 */
public class IntDistinctReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currInt = sc.nextInt();
        Set<Integer> set = new HashSet<>();

        int res = 0;
        while (currInt != 0) {
            int currChar = currInt % 10;
            if (!set.contains(currChar)) {
                res = res * 10 + currChar;
                set.add(currChar);
            }
            currInt /= 10;
        }
        System.out.println(res);
    }
}

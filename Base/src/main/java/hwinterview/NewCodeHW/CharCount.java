package hwinterview.NewCodeHW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 12:18
 */
public class CharCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currStr = sc.next();
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < currStr.length(); i++) {
            char currChar = currStr.charAt(i);
            if (!map.containsKey(currChar)) {
                res++;
                map.put(currChar, 1);
            }
        }
        System.out.println(res);
    }
}

package hwinterview.NewCodeHW;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 12:27
 */
public class MergeMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map.put(a, map.getOrDefault(a, 0) + b);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

package hwinterview.NewCodeHW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 16:13
 */

public class LastKthNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int NodeCount = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < NodeCount; i++) {
            map.put(i, sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(map.get(NodeCount - k));
    }
}

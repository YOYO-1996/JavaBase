package hwinterview;

import java.util.*;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-16 19:40
 */
public class Inter2 {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        helper(arr, 0, k);
        Collections.sort(list);

        System.out.println(list.get(k - 1));
    }

    public static void helper(int[] arr, int startIndex, int k) {
        if (startIndex >= arr.length) {
            int temp = Arrays.stream(arr).reduce(0, (a, b) -> a * 10 + b);
            list.add(temp);
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            swap(arr, i, startIndex);
            helper(arr, startIndex + 1, k);
            swap(arr, i, startIndex);
        }
    }


    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

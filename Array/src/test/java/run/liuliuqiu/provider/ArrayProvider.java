package run.liuliuqiu.provider;

import java.util.Random;


public class ArrayProvider {
    public static final int DEFAULT_LEN = 10;
    public static final int DEFAULT_MAX = 100;

    private static Random random = new Random();

    public static int[] getArray() {
        int[] arr = new int[DEFAULT_LEN];
        for (int i = 0; i < DEFAULT_LEN; i++) {
            arr[i] = random.nextInt(DEFAULT_MAX);
        }
        return arr;
    }

    public static int[] getArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }
}

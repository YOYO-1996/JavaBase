package hwinterview;

import java.util.Scanner;


/**
 * @description:
 * @author: Tong
 * @date: 2020-07-16 19:28
 */
public class Inter1 {
    int min = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] org = new int[10];
        for (int i = 0; i < 10; i++) {
            org[i] = sc.nextInt();
        }
        //1队和2队
        int[][] dp = new int[10][2];//dp[i][j]代表第i个放j对的差距

    }

}

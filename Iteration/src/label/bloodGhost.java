package label;

import common.Util;

import java.util.ArrayList;

/**
 * @description:吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘得到，二这对数字各包含成绩一半位数的数字
 * @author: Tong
 * @date: 2019-08-31 12:12
 */
public class bloodGhost {
    Util util = new Util();

    public void isBlood(char[] arr, int target) {
        ArrayList<ArrayList<Character>> arrList = new ArrayList<>();
        fullSort(arr, 0, arr.length - 1, arrList);
        for (ArrayList<Character> tempList : arrList) {
            int tempValFirst = Integer.parseInt(tempList.get(0).toString()) * 10 + Integer.parseInt(tempList.get(1).toString());
            int tempValLast = Integer.parseInt(tempList.get(2).toString()) * 10 + Integer.parseInt(tempList.get(3).toString());
            if (tempValFirst * tempValLast == target) {
                System.out.println(tempValFirst + "*" + tempValLast + "=" + target);
            }
        }
    }

    /**
     * 全排列
     *
     * @param arr
     * @param start
     * @param end
     */
    public void fullSort(char[] arr, int start, int end, ArrayList<ArrayList<Character>> arrList) {
        if (start == end) {
            ArrayList arrTemp = new ArrayList<>();
            for (char val : arr) {
                arrTemp.add(val);
            }
            arrList.add(arrTemp);
            return;
        }

        for (int i = start; i <= end; i++) {
            //递进去
            util.swap(arr, i, start);
            fullSort(arr, start + 1, end, arrList);
            //归出来
            util.swap(arr, i, start);
            //交换回来
        }

    }
}

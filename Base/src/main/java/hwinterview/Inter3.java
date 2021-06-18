package hwinterview;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 0 asdbuiodevauufgh
 * <p>
 * 2
 * aeueo
 *      1
 * aabeebuu
 * @author: Tong
 * @date: 2020-07-16 20:30
 */
public class Inter3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> listC = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int maxFlaw = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        int len = str.length();

        int startIndex = findFisrtYun(str, 0, len - 1, listC);
        //一个都没
        if (startIndex == -1) {
            System.out.println(0);
            return;
        }
        int right = startIndex;

        int currFlaw = 0;
        int maxlen = currFlaw == maxFlaw ? 1 : 0;

        while (startIndex <= right && right < len - 1) {

            right++;
            char currChar = str.charAt(right);
            //是韵母，且瑕疵度满足，算长度
            if (listC.contains(currChar)) {
                if (currFlaw == maxFlaw) {
                    maxlen = Math.max(maxlen, right - startIndex + 1);
                }
            } else {//不是韵母
                //瑕疵度+1
                currFlaw++;
                //瑕疵度超过最大
                while (currFlaw > maxFlaw && startIndex < right) {
                    startIndex++;
                    //缩减的是韵母
                    if (!listC.contains(str.charAt(startIndex))) {
                        //不是韵母
                        currFlaw--;
                    }
                }
                //保证瑕疵度不保证startIndex为韵母
                //startIndex不是韵母
                while (!listC.contains(str.charAt(startIndex)) && startIndex < right) {
                    startIndex++;
                    currFlaw--;
                }
                if (startIndex == right) {
                    startIndex = findFisrtYun(str, right, len - 1, listC);
                    if (startIndex == -1) {
                        break;
                    } else {
                        right = startIndex;
                    }
                }
            }
        }
        System.out.println(maxlen);
    }

    static int findFisrtYun(String str, int left, int right, List listC) {
        for (int i = left; i <= right; i++) {
            if (listC.contains(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

}

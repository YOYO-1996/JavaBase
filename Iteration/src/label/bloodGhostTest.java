package label;

/**
 * @description:
 * @author: Tong
 * @date: 2019-08-31 12:53
 */
public class bloodGhostTest {
    public static void main(String[] args) {
        bloodGhost bg = new bloodGhost();
        for (int i = 1001; i < 10000; i++) {
            bg.isBlood(Integer.toString(i).toCharArray(),i);
        }
    }
}

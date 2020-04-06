package func;

/**
 * @description:
 * @author: Tong
 * @date: 2020-04-05 9:50
 */
public class InternTest {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);// false

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);// true
    }
}

package hwinterview.inputTest;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;
        import java.util.Scanner;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 11:20
 */
public class HWTest7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int strCount = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strCount; i++) {
            list.add(sc.next());
        }
        Optional<String> stringOptional = list.stream().sorted().reduce((a, b) -> a + " " + b);
        System.out.println(stringOptional.get());
    }
}

package run.liuliuqiu;

import static run.liuliuqiu.provider.ArrayProvider.getArray;
import java.util.Arrays;
import org.junit.Test;


public class ArraysTest {

    @Test
    public void sortTest() {
        int[] arr = getArray();
        Arrays.sort(arr);
    }
}

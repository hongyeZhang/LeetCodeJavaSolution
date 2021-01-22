import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: ZHQ
 * @Date: 2020/12/15
 */
public class TmpTest {

    @Test
    public void test() {
        int[] arr = new int[10];
        Arrays.fill(arr, 10);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}

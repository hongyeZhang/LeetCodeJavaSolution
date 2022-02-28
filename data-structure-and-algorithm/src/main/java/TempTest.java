import org.junit.Test;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-08-07
 **/
public class TempTest {


    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }


    @Test
    public void test() {
        int[] inputs = {3, 5, 3, 7, 2, 6, 4, 7, 8};
        quickSort(inputs, 0, inputs.length - 1);
        for (int input : inputs) {
            System.out.print(input + "\t");
        }
    }


}

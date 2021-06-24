import java.util.Arrays;

public class BubbleSort {

    /**
     * 冒泡：比较相邻元素，前比后大，就交换
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public void Bubble(int[] nums) {
        if (nums == null) {
            return;
        }

        for (int i = nums.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }

        }
    }


    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 6, 7, 8, 10, 23};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.Bubble(nums);
        System.out.println(Arrays.toString(nums));
    }



}

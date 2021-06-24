import java.util.Arrays;

public class InsertSort {
    /**
     * 插入排序思路：把数组分为两组，一组是已排序，一组是未排序的
     * @param nums
     */
    public static void InsertSort(int[] nums) {
        //从第二个数字开始插入，第一个数字默认是已排序
        for (int i = 1; i < nums.length; i++) {
            //和前面的有序作比较，比前面一个小就交换，否则就直接退出（因为前面已经从小到大排好序）
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                } else{
                    break;
                }
            }
        }
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1, 13, 46, 24, 1356, 42145, 774241, 772};
        InsertSort(nums);
        System.out.println(Arrays.toString(nums));

    }
}

import java.util.Arrays;

public class MergeSort {

    private static int[] temp;

    public static void sort(int[] nums) {
        temp = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        sort(nums, left, right);
    }


    public static void sort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = left + (right - left) / 2;

        //对left到mid进行排序（递归到最后是只有一个元素）
        sort(nums, left, mid);
        //对mid+1 到right进行排序
        sort(nums, mid + 1, right);

        //对left到mid和mid到right进行归并
        merger(nums, left, mid, right);
    }


    public static void merger(int[] nums, int left, int mid, int right) {
        //left到right这两组数据归并到辅助数组的对应的索引出处
        int i = left;
        //左边数组的指针
        int p1 = left;
        //右边数组的指针
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] < nums[p2]) {
                temp[i] = nums[p1];
                i++;
                p1++;
            } else {
                temp[i] = nums[p2];
                i++;
                p2++;
            }
        }

        //跳出循环说明有一个数组已经全部遍历完，还有一个还没遍历完
        while (p1 <= mid) {
            temp[i] = nums[p1];
            i++;
            p1++;
        }
        while (p2 <= right) {
            temp[i++] = nums[p2++];
        }

        //现在temp数组中的left到right是有序的，则拷贝到原数组中
        for (int j = left; j <= right; j++) {
            nums[j] = temp[j];
        }
    }


    public static void main(String[] args) {
        int[] nums = {3545, 2354, 432, 1113, 56, 5426, 471, 4546};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

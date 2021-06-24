import java.util.Arrays;

public class QuickSort {

    public void Quicksort(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        sort(nums, left, right);
    }

    public void sort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int KeyIndex = partition(nums, left, right);

        sort(nums, left, KeyIndex - 1);
        sort(nums, KeyIndex + 1, right);
    }

    //这个地方 返回值就是基准值所在的索引
    public int partition(int[] nums, int left, int right) {
        int key = nums[left];
        //定义两个指针，左侧指针指向最左端，右侧指针指向最右端的下一个元素，做一个预留
        int lp = left, rp = right + 1;
        while (true) {
            //右边的值都要大于基准值就，先从右往左扫描
            while (nums[--rp] > key){//说明找到了小于key的值
                if(rp == left){
                    break;
                }
            }

            while (nums[++lp] < key) { //++i,是加后再返回，从key的右边一个开始找
                if (lp == right) {
                    break;
                }
            }

            if (lp >= rp) {
                break; //此时已经扫描完所有元素，结束循环
            } else { //否则就交换两个索引元素的位置
                swap(nums, lp, rp);
            }
        }
        //当（lp+1，rp）所有的节点排好序后，此时，lp和rp指针指向同一个位置，这个位置应该是小于key的（因为先想左寻找小的
        swap(nums, left, rp);
        return rp;
    }



    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {6, 2, 4, 1, 5, 7, 9, 8, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.Quicksort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

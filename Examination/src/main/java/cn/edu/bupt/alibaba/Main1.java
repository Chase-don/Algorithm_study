package cn.edu.bupt.alibaba;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //有n个数
        int k = sc.nextInt();  //翻转的次数
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        for(int j = 0; j < k; j++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            reverseSort(nums, l, r);
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void reverseSort(int[] nums, int left, int right) {
        int realLeft = left - 1;
        int realRight = right - 1;
        while (realLeft < realRight) {
            int temp = nums[realLeft];
            nums[realLeft] = nums[realRight];
            nums[realRight] = temp;
            realLeft++;
            realRight--;
        }
    }
}

package cn.edu.bupt.baidu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ans = new int[t];
        int index = 0;
        while (t-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            ans[index++] = tree(i, j);
        }
        for (int num : ans) {
            System.out.println(num);
        }
    }

    public static int tree(int i, int j) {
        int left = 0;
        int right = 0;
        int x = 1;
        while (i >= x) {
            x *= 2;
            left++;
        }
        x = 1;
        while (j >= x) {
            x *= 2;
            right++;
        }

        int count1 = Math.max(left - right, right - left);
        if (left > right) {
            while (left > right) {
                i /= 2;
                left--;
            }
        } else if (left < right) {
            while (right > left) {
                right--;
                j /= 2;
            }
        }

        int count2 = 0;
        while (i != j) {
            i /= 2;
            j /= 2;
            count2++;
        }

        return count1 + count2 * 2;
    }
}

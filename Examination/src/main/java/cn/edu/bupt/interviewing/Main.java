package cn.edu.bupt.interviewing;

import java.util.Scanner;

public class Main{

    static int N = 100010;  // 数据规模为 10w
    static int[] b = new int[N];    // b数组为 nums数组的差分
    static int[] nums = new int[N];  // nums数组为 b数组的前缀和

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 1; i <=n; i++){
            nums[i] = sc.nextInt();
        }

        // 初始化 b数组
        for (int i = 1; i <= n; i++) {
            // 相当于将 nums 中全部看为 0, 则 b[n]中也全部都为 0, 再在其中区间 [i, i] 添加 arr[i], 求出 b[i]
            // 牛逼，这个地方不理解就自己手写推一下
            insert(i, i, nums[i]);
        }

        // m次循环操作
        while(m-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            insert(l,r,c);
        }

        // 求数组 nums插入元素后的值, 相当于求 b[n]的前缀和
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i - 1] + b[i];
            System.out.print(nums[i] + " ");
        }

    }

    static void insert(int l, int r, int c){
        b[l] += c;
        b[r + 1] -= c;
    }
}
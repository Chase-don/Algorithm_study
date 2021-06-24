package cn.edu.bupt.bag;

import java.util.Scanner;

public class MultiplePack01 {
    /**
     * 朴素做法
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        int[] s = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j <= V; j++) {
                //注意： 别忘了 k * v[i] <= j 这个条件
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i] * k] + w[i] * k);
                }
            }
        }

        System.out.println(dp[N][V]);

    }
}

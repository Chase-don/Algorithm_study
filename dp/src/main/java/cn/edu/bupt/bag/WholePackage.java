package cn.edu.bupt.bag;

import java.util.Scanner;

public class WholePackage {
    /**
     * 朴素做法 -- 类似于0-1 背包
     */
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int V = sc.nextInt();
//        int[] w = new int[N + 1];
//        int[] v = new int[N + 1];
//        for(int i = 1; i <= N; i++){
//            v[i] = sc.nextInt();
//            w[i] = sc.nextInt();
//        }
//
//
//        int[][] dp = new int[N + 1][V + 1];
//        dp[0][0] = 0;
//
//        for(int i = 1; i <= N; i++){
//            for(int j = 0; j <= V; j++){
//                for(int k = 0; k * v[i] <= j; k++){
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
//                }
//            }
//        }
//        System.out.println(dp[N][V]);
//    }


    /**
     * 优化做法：
     * 发现dp[i][j] 和  dp[i][j - v]的关系
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] w = new int[N + 1];
        int[] v = new int[N + 1];
        for(int i = 1; i <= N; i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }


        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= V; j++){
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[N][V]);
    }



}


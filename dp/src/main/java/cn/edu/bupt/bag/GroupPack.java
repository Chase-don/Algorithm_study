package cn.edu.bupt.bag;

import java.util.Scanner;


public class GroupPack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //物品组数
        int N = sc.nextInt();
        //背包容量
        int V = sc.nextInt();
        int Max = 101;
        int[][] v = new int[Max][Max];
        int[][] w = new int[Max][Max];
        int[] S = new int[N + 1];
        for(int i = 1; i <= N; i++){
            //第i组的物品数量
            S[i] = sc.nextInt();
            for(int j = 1; j <= S[i]; j++){
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }

         //二维写法
        /**
         * 本解法主要用来描述二维dp的记录，在每一次遍历分组时，使用临时变量来记录最大值，而非直接覆盖
         * 当然，复杂度比一维dp有所增加，此解法主要用来解决为什么不能直接使用以下公式的疑惑
         * dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - v] + w);
         */
         int[][] dp = new int[N + 1][V + 1];
         dp[0][0] = 0;

         for(int i = 1; i <= N; i++){
             for(int j = 0; j <= V; j++){
                 // temp用来记录该分组内本次循环的最大值，如果不设置该值，
                 // 则会导致每次循环记录的是大于dp[i - 1][j]的最后一个满足条件的k的值，而不是最值！这个十分重要
                 int temp = 0;
                 for(int k = 0; k <= S[i]; k++){
                     dp[i][j] = dp[i - 1][j];
                     if(j >= v[i][k]){
                         dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i][k]] + w[i][k]);
                         temp = temp > dp[i][j]?temp:dp[i][j];
                     }
                 }
                 dp[i][j] = temp > dp[i][j]?temp:dp[i][j];
             }
         }


         System.out.println(dp[N][V]);


//        //一维写法（因为都是i-1，所以j要从大到小）
//        int[] dp = new int[V + 1];
//
//        for(int i = 1; i <= N; i++){
//            for(int j = V; j >= 0; j--){
//                for(int k = 0; k <= S[i]; k++){
//                    if(j >= v[i][k]){
//                        dp[j] = Math.max(dp[j], dp[j - v[i][k]] + w[i][k]);
//                    }
//                }
//            }
//        }
//        System.out.println(dp[V]);

    }
}
package cn.edu.bupt.bag;


import java.util.Scanner;

public class ZeroOnePackage {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int V = sc.nextInt();
//        int[] v = new int[N + 1];
//        int[] w = new int[N + 1];
//        for(int i = 1; i <= N; i++){
//            v[i] = sc.nextInt();
//            w[i] = sc.nextInt();
//        }
//
//
//        /**
//        定义一个二阶矩阵dp[N+1][V+1],
//        这里之所以要N+1和V+1，是因为第0行表示只能选择第0个物品的时候，即没有物品的时候
//        第0列表示背包的体积为0的时候，即不能装任何东西的时候
//
//        dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
//        对于dp[i][j]有两种情况：
//        1. 不选择当前的第i件物品/第i件物品比背包容量要大，则dp[i][j] = dp[i-1][j]
//        2. 选择当前的第i件物品（潜在要求第i件物品体积小于等于背包总容量），则能装入的物品最大价值为：
//            当前物品的价值 加上 背包剩余容量在只能选前i-1件物品的情况下的最大价值
//            dp[i][j] = dp[i-1][j-v[i]] + w[i]
//        dp[i][j]在两种情况中选择比较大的情况作为当前的最优解；
//        即：
//        if(j >= v[i]):
//            dp[i][j] = max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
//        else:
//            dp[i][j] = dp[i-1][j]
//        */
//        int[][] dp = new int[N+1][V+1];
//
//        dp[0][0] = 0; //表示取0个物品且背包体积为0时的价值为0
//
//        //i代表第i个物品，j代表总体积
//        for(int i = 1; i <= N; i++){
//            for(int j = 0; j <= V; j++){
//                if(j >= v[i]){
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
//                }else{
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        System.out.println(dp[N][V]);
//    }



    //优化后
    public static void main(String[] args) throws Exception {
        // 读入数据的代码
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int V = reader.nextInt();
        // 一个长度为N的数组，第i个元素表示第i个物品的体积；
        int[] v = new int[N + 1] ;
        // 一个长度为N的数组，第i个元素表示第i个物品的价值；
        int[] w = new int[N + 1] ;

        for (int i=1 ; i <= N ; i++){
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            v[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        reader.close() ;

        // 正式算法的代码
        // 将dp优化为一维数组
        /**
        注意，这里第二层循环的时候，还是小到大循环的话，那么

        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
        实际上变成了
        dp[i][j] = Math.max(dp[i][j], dp[i][j-v[i]] + w[i]);

        因为i-1的值已经在前面被更新过了，覆盖了
        为了避免这个问题，所以要逆序更新，即先更新第i个，然后更新第i-1个，从而保证第i-1个不被覆盖

        如果不逆序的话，输出结果为10，dp数组实际为：
        0 0 0 0 0 0
        0 2 4 6 8 10
        0 2 4 6 8 10
        0 2 4 6 8 10
        0 2 4 6 8 10
        */
        int[] dp = new int[V+1];
        dp[0] = 0;
        for(int i = 1; i <= N; i++){
            for(int j = V; j >= v[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-v[i]] + w[i]);
            }
            // for(int j = 0; j <= V; j++){
            //     System.out.print(dp[j]);
            //     System.out.print(" ");
            // }
            // System.out.print("\n");
        }
        System.out.println(dp[V]);
    }
}

package cn.edu.bupt.acwing;

import java.util.*;
// 合并区间
public class Main803 {
    static int N = 100010;
    static int[][] res = new int[N][2];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //区间的二维数组表示为：
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        res = merge(nums);
        System.out.println(Arrays.deepToString(res));
        System.out.println(res.length);
    }


    static int[][] merge(int[][] nums){
        // 1. 先将区间按照左端点从小到大排序
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        //代表现在结果res中还没有区间添加进来
        //同时idx代表res二维数组的前一个索引值，即二维数组的第idx行
        int idx = -1;

        // 2. 遍历所有的区间
        for(int[] num : nums){
            //res数组中没有区间或者上一个区间的右端点小于当前区间的左端点，则把当前区间添加到res数组中
            if(idx == -1 || res[idx][1] < num[0]){
                res[++idx] = num;
            } else{ // 上一个区间和当前区间有重合
                res[idx][1] = Math.max(res[idx][1], num[1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }
}

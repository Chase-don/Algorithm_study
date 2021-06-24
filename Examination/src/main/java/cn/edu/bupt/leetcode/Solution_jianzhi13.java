package cn.edu.bupt.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_jianzhi13 {
    static int M = 110, N = 110;
    static int[][] used = new int[M][N];
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(movingCount(m, n, k));
    }

    public static int movingCount(int m, int n, int k) {
        bfs(m, n, k);
        return res;
    }

    static void bfs(int m, int n, int k){
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0, 0));
        used[0][0] = 1;
        res++;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(getSum(new Pair(x,y)) <= k && x >= 0 && x < m && y >= 0 && y < n && used[x][y] == 0){
                    q.offer(new Pair(x, y));
                    res++;
                    used[x][y] = 1;
                }
            }
        }
    }

    //某个坐标的数位和
    static int getSum(Pair p){
        return getSingle(p.x) + getSingle(p.y);
    }

    //单个数字的数位和
    static int getSingle(int x){
        int sum = 0;
        while(x != 0){
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

class Pair{
    int x;
    int y;
    public Pair(){}
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
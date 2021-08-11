package cn.edu.bupt.shopee;

import java.util.*;



public class Main {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     * @param rooms int整型二维数组 房间
     * @param startPoint int整型一维数组 起始点
     * @param endPoint int整型一维数组 终点
     * @return int整型
     */
    int N = 210;
    int M = 210;
    int[][] used = new int[M][N];
    public int minimumInitHealth(int[][] rooms, int[] sp, int[] ep) {
        // write code here
        int k = bfs(rooms, sp, ep);
        return Math.abs(k) + 1;
    }

    int bfs(int[][] rooms, int[] sp, int[] ep){
        int m = rooms.length;
        int n = rooms[0].length;
        int res = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sp[0], sp[1]));
        used[sp[0]][sp[1]] = 1;
        res += rooms[sp[0]][sp[1]];

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && used[x][y] == 0) {
                    res += rooms[x][y];
                    q.offer(new Pair(x, y));
                }
            }
        }
        return res;
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

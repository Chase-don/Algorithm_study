package cn.edu.bupt.acwing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main843_nQuene {
    static char[][] grid;
    // static char[][] grid = new char[N][N];
    static boolean[] col;
    static boolean[] row;
    static boolean[] dg;
    static boolean[] udg;
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // n * n 的棋盘
        n = sc.nextInt();
        col = new boolean[n];
        dg = new boolean[2 * n];
        udg = new boolean[2 * n];
        grid  = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = '.';
            }
        }
        dfs(0, 0, 0);
    }

    //x和y代表是棋盘的哪一个格子，s是当前已经放了几个皇后
    static void dfs(int x, int y, int s){
        if(x == n){
            x = 0;
            y++;
        }
        if(y == n){
            if(s == n){
                for(int i = 0; i < n; i++){
                    System.out.println(grid[i]);
                    System.out.println();
                }
            }
            return;
        }

        //不放皇后
        dfs(x + 1, y, s);

        //放皇后（需要判断一下，行、列、对角线、反对角线都不能有皇后），如果都没有的话就放皇后
        if(!row[y] && !col[x] && !dg[y + x] && !udg[y - x + n]){
            grid[x][y] = 'Q';
            row[y] = col[x] = dg[y + x] = udg[y - x + n] = true;
            dfs(x + 1, y, s + 1);
            //恢复现场
            row[y] = col[x] = dg[y + x] = udg[y - x + n] = false;
            grid[x][y] = '.';
        }
    }




}

package cn.edu.bupt.alibaba;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] people = new int[n][2];
            for (int j = 0; j < n; j++) {
                people[j][0] = sc.nextInt();
                people[j][1] = sc.nextInt();
            }
            int time = 1;
            int[] ans = new int[n];
            for (int j = 0; j < n; j++) {
                if (time <= people[j][0]) {
                    ans[j] = people[j][0];
                    time = people[j][0] + 1;
                } else if (time > people[j][0] && time <= people[j][0]) {
                    ans[j] = time;
                    time++;
                } else {
                    ans[j] = 0;
                }
            }
            for(int x = 0; x < t; x++){
                for (int j = 0; j < n - 1; j++) {
                    System.out.print(ans[j] + " ");
                }
                System.out.println(ans[n - 1]);
            }
        }
    }
}

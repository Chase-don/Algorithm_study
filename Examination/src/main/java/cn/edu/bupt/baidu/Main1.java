package cn.edu.bupt.baidu;

import java.util.Scanner;

public class Main1 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int k = sc.nextInt();
        dfs(s1, s2, 0, k);
        System.out.println(ans);
    }

    public static void dfs(String s1, String s2, int count, int k) {
        if (count == k) {
            if (s1.equals(s2)) {
//                ans = (ans + 1) % 1000000007;
                ans++;
//                System.out.println(ans);
            } else {
//                System.out.println("不对");
            }
            return;
        }

        for (int i = 0; i < s1.length() - 1; i++) {
            String str = s1.substring(i + 1) + s1.substring(0, i + 1);
//            System.out.println(str);
            dfs(str, s2, count + 1, k);

        }
    }
}

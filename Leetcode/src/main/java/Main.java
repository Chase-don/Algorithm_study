import java.util.Scanner;

public class Main{
    static int max_money = 0;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        int[] money = new int[n];
        for(int i = 0; i < n; i++){
            int s = sc.nextInt();
            start[i] = s;
        }
        for(int i = 0; i < n; i++){
            int e = sc.nextInt();
            end[i] = e;
        }
        for(int i = 0; i < n; i++){
            int m = sc.nextInt();
            money[i] = m;
        }

        boolean[] used_time = new boolean[25];
        dfs(used_time, start, end, money, 0, 0);
        System.out.println(max_money);
    }


    static void dfs(boolean[] used_time, int[] start, int[] end, int[] money, int index, int cur_money) {
//        System.out.println(index);
        if (index == money.length) {
            max_money = Math.max(max_money, cur_money);
        } else {
            for (int i = index; i < money.length; i++) {
                boolean flag = true;
                for (int j = start[i]; j <= end[i]; j++) {
                    if (used_time[j]) {
                        flag = false;
                        break;
                    } else {
                        used_time[j] = true;
                    }
                }
                if (flag) {
                    dfs(used_time, start, end, money, i + 1, cur_money + money[i]);
                }
                for (int j = start[i]; j <= end[i]; j++) {
                    used_time[j] = false;
                }
            }
        }
    }
    //4
    //1 2 3 3
    //3 4 5 6
    //200 150 180 210
}
package cn.edu.bupt.acwing;

import java.util.*;

public class Main848{
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx;
    static int n, m;
    static int[] d = new int[N];  //入度数
    static Queue<Integer> q = new LinkedList<>();

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean topSort(){
        for(int i = 1; i <= n; i++){
            if(d[i] == 0){
                q.offer(i); //把所有入度为0的点添加到队列中
            }
        }
        while(!q.isEmpty()){
            int t = q.poll();
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                d[j]--;
                if(d[j] == 0){
                    q.offer(j);
                }
            }
        }
        return q.size() == n;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Arrays.fill(h, -1);
        n = sc.nextInt();
        m = sc.nextInt();
        while(m-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
            d[b]++;
        }
        if(topSort()){
            // while(!q.isEmpty()){
            //     int x = q.poll();
            //     System.out.print(x + " ");
            // }
            Iterator<Integer> temp = q.iterator();
            while(temp.hasNext()) System.out.print(temp.next() + " ");
        } else{
            System.out.println("-1");
        }


    }
}
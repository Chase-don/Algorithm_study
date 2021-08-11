package cn.edu.bupt.interviewing;

import java.math.BigDecimal;
import java.util.*;

//n个人 a块钱

public class Main3 {


    static ArrayList list = new ArrayList();;

    public static BigDecimal bianLiJia(ArrayList list) {
        BigDecimal b = new BigDecimal("0");

        for (int i = 0; i < list.size(); i++) {
            b = b.add(list.get(i));

        }

        return b;

    }

    public static void bianLiJian(BigDecimal b1, BigDecimal b2) {
        if (bianLiJia(list).doubleValue() < b1.doubleValue()) {
            BigDecimal b3 = bianLiJia(list);

            BigDecimal b4 = b1.subtract(b3);

            int i = 0;

            list.set(i = (int) (Math.random() * (b2.intValue())), list.get(i).add(b4));

        } else if (bianLiJia(list).doubleValue() > b1.doubleValue()) {
            BigDecimal b3 = bianLiJia(list);

            BigDecimal b4 = b3.subtract(b1).divide(b2, 2, BigDecimal.ROUND_FLOOR);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).doubleValue() > b4.doubleValue()) {
                    list.set(i, list.get(i).subtract(b4));

                }

            }

        }

        if (bianLiJia(list).doubleValue() > b1.doubleValue()) {
            BigDecimal b3 = bianLiJia(list);

            BigDecimal b4 = b3.subtract(b1);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).doubleValue() > b4.doubleValue()) {
                    list.set(i, list.get(i).subtract(b4));

                }

            }

            bianLiJian(b1, b2);

        }

    }

    public static ArrayList genRedPacket(String total, int count) {
        BigDecimal b1 = new BigDecimal(total);

        BigDecimal b2 = new BigDecimal(count);

        for (int i = 0; i < count; i++) {
            String s = String.valueOf(((int) (Math.random() * (Integer.parseInt(total) + 1)))

                    + ((int) (Math.random() * 100) + 1) / 100.0);

            BigDecimal b3 = new BigDecimal(s);

            list.add(b3);

        }

        bianLiJian(b1, b2);

        return list;

    }

    public void fhb(String total, int count) {
        genRedPacket(total,count);

        int i = 1;

        for(BigDecimal b:list) {
            System.out.println("第"+i+"个红包:"+b+"元");

            i++;

        }

    }






    public static void main(String[] args) {
        helper(5, 10);
        for (double num : res) {
            System.out.println(num);
        }
    }

//    static int helper(TreeNode root){
//        if(root == null) return 0;
//        return Math.max(helper(root.left), helper(root.right)) + 1;
//    }

    //n个人
//    static void helper(int n, double money){
////        if(money == 0 && n == 0){
////            return;
////        }
//        if(money == 0 && n != 0) return;
//        double k = Integer.MAX_VALUE;
//        Random ran = new Random();
//        while (k <= 0 || k >= money) {
//            k = ran.nextDouble();
//        }
//        res.add(k);
//        money -= k;
//        n--;
//        helper(n, money);
//        res.remove(res.get(res.size() - 1));
//    }


}


//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    public TreeNode(){}
//
//    public TreeNode(int val, TreeNode left, TreeNode right){
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}



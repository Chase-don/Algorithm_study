package cn.edu.bupt.interviewing;

import java.util.*;

public class Main2 {
    static List<Integer> res = new ArrayList<>();
    static Deque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2};
        List<Integer> helper = helper(nums);
        for (int x : helper) {
            System.out.print(x + " ");

        }

    }

    static List<Integer> helper(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.getFirst() > nums[i]) {
                stack.removeFirst();
            }

            if (stack.isEmpty() || stack.getFirst() < nums[i]) {
                stack.addFirst(nums[i]);
            }
        }

        while (!stack.isEmpty()) {
            res.add(stack.removeFirst());
        }
        Collections.reverse(res);

        return res;
    }





}

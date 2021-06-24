package cn.edu.bupt.acwing;

import java.util.*;

public class Main{
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findSum(nums, 10));
    }


    static List<List<Integer>> findSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(target - nums[i])) {
                m.put(nums[i], i);
            } else {
                List<Integer> res = new ArrayList<>();
                res.add(i);
                res.add(m.get(target - nums[i]));
                list.add(res);
            }
        }
        return list;
    }
}
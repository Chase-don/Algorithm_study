package cn.edu.bupt.interviewing;

import java.util.HashMap;
import java.util.Map;

class Key{
    int num;

    @Override
    public int hashCode() {
        return num;
    }
}

public class Solution {
    public static void main(String[] args) {
        Map<Key, Integer> m = new HashMap<>();
        Key k1 = new Key();
        k1.num = 10;
        m.put(k1, 1);
        k1.num = 12;
        System.out.println(m.containsKey(k1));
        Integer v = m.get(k1);
        System.out.println(v);
        k1.num = 10;
        System.out.println(m.get(k1));
    }

}

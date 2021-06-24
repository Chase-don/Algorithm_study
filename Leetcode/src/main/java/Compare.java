import java.util.PriorityQueue;

public class Compare {
    public static String compare(String s1, String s2) {

        int l = 0, r = 0;


        while (l < s1.length() && r < s2.length()) {
            if (s1.charAt(l) < s2.charAt(r)) {
                return s2;
            } else if (s1.charAt(l) > s2.charAt(r)) {
                return s1;
            } else {
                l += 2;
                r += 2;
            }
        }

        if (s1.length() < s2.length()) {
            return s2;
        } else {
            return s1;
        }




    }

    public static void main(String[] args) {
//        String s1 = "1.1.2.4";
//        String s2 = "1.3.2";

//        String s1 = "1.1.2";
//        String s2 = " ";
        String s1 = "1.1.2";
        String s2 = "1.0.2";
        System.out.println(compare(s1, s2));
    }
}

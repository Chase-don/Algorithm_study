package cn.edu.bupt.interviewing;

public class DiDi {
    public static void main(String[] args) {
        String str = "a";
        helpers(str);
        Long l = 100L;
        helperL(l);
        System.out.println(l);
        System.out.println(str);
    }

    static String helpers(String s) {
        s = "b";
        return s;
    }

    static void helperL(Long l) {
        l = 2000L;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-15 16:51:53
 * @LastEditTime: 2022-09-07 10:48:24
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/TestInteger.java
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer a = 129000000;
        Integer b = 129000000;
        System.out.println(a == b);

        for (int i = 0; i < 0; i++) {
            System.out.println("ss");
        }
        int[] arr = new int[]{1, 2};
        System.out.println(Arrays.toString(arr) + arr.length);

        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * (long)1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        String aaa = "abc";
        System.out.println(aaa.substring(1,2) + aaa.length());

        System.out.println(2147483600 + (2147483600 - 2147483600) / 2);

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        addList(ans);
        System.out.println(ans);

        boolean[][] canReachP = new boolean[2][2];
        canReachP[0][1] = true;
        System.out.println(Arrays.toString(canReachP[1]));

        String tt = "hhh";
        tt = TestInteger.changeString(tt);
        System.out.println(tt);
        StringBuilder ttt= new StringBuilder("hhh");
        TestInteger.changeStringBuilder(ttt);
        System.out.println(ttt.toString());

        Queue<int[]> points = new LinkedList<>();
        points.offer(new int[]{1, 2});
        System.out.println(points.contains(new int[]{1, 2}));

        boolean test = true;
        changeBool(test);
        System.out.println(test);

        int corr = 701 / 26;
        System.out.println(corr);

        int cha = 1;
        StringBuilder str = new StringBuilder();
        str.append(String.valueOf(cha));
        System.out.println(str.toString());

        int w = 1;
        changeInt(w);
        System.out.println(w);

        // int[] aaaa = new int[]{1,2,3,4};
        // for (int i : aaaa) {
        //     i = 3;
        // }
        // System.out.println(Arrays.toString(aaaa));
    }
    public static void changeInt(int s) {
        s = 2;
    }
    public static String changeString(String s) {
        s = "change!";
        return s;
    }
    public static void changeStringBuilder(StringBuilder s) {
        s = new StringBuilder("change");
    }
    public static void addList(List<Integer> ans) {
        ans.add(2);
    }
    public static void changeBool(Boolean test) {
        test = false;
        return;
    }
    
    
}

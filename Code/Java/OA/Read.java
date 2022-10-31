/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-24 17:06:43
 * @LastEditTime: 2022-10-24 17:13:03
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/OA/Read.java
 */
package OA;

import java.util.Arrays;

public class Read {
    public static void main(String[] args) {
        String s = "@123: dd; @31:dsa";
        // String[] sp = s.split("@\\d+:");
        String[] sp = s.split("@\\d+:\\s*");
        System.out.println(Arrays.toString(sp));
    }
}

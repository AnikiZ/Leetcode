/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-24 17:06:43
 * @LastEditTime: 2022-11-07 18:01:56
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/OA/Read.java
 */
package OA;

import java.util.Arrays;

public class Read {
    public static void main(String[] args) {
        String s = "@123: dd; @31:dsa";
        String words = "asd dsa";
        String[] word = words.split(" ");
        System.out.println(Arrays.toString(word));
        // String[] sp = s.split("@\\d+:");
        String[] sp = s.split("@\\d+:\\s*");
        System.out.println(Arrays.toString(sp));
    }
}

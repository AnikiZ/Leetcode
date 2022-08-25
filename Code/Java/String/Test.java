/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-18 01:24:49
 * @LastEditTime: 2022-08-23 12:30:50
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/Test.java
 */
// javac Test.java
// java -classpath ../ String.Test 在String目录下运行该命令行可以执行
// 或者去上级(..) 然后 java String.Test
// 因为有package存在！
package String;

public class Test {
    public static void main(String[] args) {
        int i = 0;
        add(i);
        System.out.println(i);
        StringBuilder ans = new StringBuilder();
        ans.append(58);
        ans.append('0');

        // 异号测试 >>> 是逻辑右移，不带符号， >>是算术右移，带符号
        int positive = 100000;
        int negative = -110001;

        System.out.println(((positive >>> 31) ^ (negative >>> 31)) == 1);
        
        // 这个就会化成ascii码对应的数字！
        ans.append('0' + 1);
        System.out.println(ans);
    }
    public static void add(int i) {
        i++;
    }
}

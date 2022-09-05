/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-09-04 23:06:11
 * @LastEditTime: 2022-09-04 23:13:17
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/Tree/TestImplement.java
 */
package Tree;
interface A {
    void read();
}
interface B {
    void write();
}

class C implements A, B {

    @Override
    public void write() {
        System.out.println("wtring...");
        
    }

    @Override
    public void read() {
        System.out.println("reading....");
    }
}
public class TestImplement {
    public static void main(String[] args) {
        // C c = new C();
        A a = new C();
        a.read();
        B b = (B) a;
        b.write();
    }
}

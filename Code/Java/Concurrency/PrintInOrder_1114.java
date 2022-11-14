/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-13 20:46:59
 * @LastEditTime: 2022-11-13 20:58:03
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Concurrency/PrintInOrder_1114.java
 */
package Concurrency;

public class PrintInOrder_1114 {
    class Foo {
        private int flag;
        private Object obj;
    
        public Foo() {
            flag = 1;
            obj = new Object();
        }
    
        public void first(Runnable printFirst) throws InterruptedException {
            synchronized(obj) {
                flag = 2;
                printFirst.run();
                // must notifyAll! otherwise if notify third,
                // third is awake and check not pass,
                // continue to wait while second is also waiting,
                // nothing will move on.
                obj.notifyAll();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            
        }
    
        public void second(Runnable printSecond) throws InterruptedException {
            synchronized(obj) {
                while (flag != 2) {
                    obj.wait();
                }
                printSecond.run();
                flag = 3;
                obj.notifyAll();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
        }
    
        public void third(Runnable printThird) throws InterruptedException {
            
            // printThird.run() outputs "third". Do not change or remove this line.
            synchronized(obj) {
                while (flag != 3) {
                    obj.wait();
                }
                printThird.run();
            // obj.notifyAll();
            }
        }
    }
}
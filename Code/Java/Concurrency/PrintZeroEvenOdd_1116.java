/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-13 01:19:33
 * @LastEditTime: 2022-11-13 19:02:25
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Concurrency/PrintZeroEvenOdd_1116.java
 */
package Concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd_1116 {
    class ZeroEvenOdd {
        private int n;
        private Semaphore zero = new Semaphore(1);
        private Semaphore odd = new Semaphore(0);
        private Semaphore even = new Semaphore(0);
        public ZeroEvenOdd(int n) {
            this.n = n;
        }
    
        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zero.acquire();
                if ((i & 1) == 0) {
                    printNumber.accept(0);
                    even.release();
                } else {
                    printNumber.accept(0);
                    odd.release();
                }
            }
        }
    
        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if ((i & 1)== 0) {
                    even.acquire();
                    printNumber.accept(i);
                    zero.release();
                }
            }
        }
    
        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if ((i & 1)!= 0) {
                    odd.acquire();
                    printNumber.accept(i);
                    zero.release();
                }
            }
        }
    }
}

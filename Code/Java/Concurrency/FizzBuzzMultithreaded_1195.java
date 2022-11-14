/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-13 00:42:27
 * @LastEditTime: 2022-11-13 00:42:27
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Concurrency/FizzBuzzMultithreaded_1195.java
 */
package Concurrency;

import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded_1195 {
    class FizzBuzz {
        private int n;
    
        public Object obj = new Object();
        public int i = 1;
    
        public FizzBuzz(int n) {
            this.n = n;
        }
    
        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            synchronized(obj) {
                while (i <= n) {
                    if (i%3==0 && i %5 != 0) {
                        printFizz.run();
                        i++;
                        obj.notifyAll(); // 通知所有！不用all时间过不去
    
                    } else {
                        obj.wait();
                        
                    }
                }
            }
        }
    
        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            synchronized(obj) {
                while (i <= n) {
                    if (i%3!=0 && i %5 == 0) {
                        printBuzz.run();
                        i++;
                        obj.notifyAll();
                    } else {
                        obj.wait();
                        
                    }
                }
            }
        }
    
        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            synchronized(obj) {
                while (i <= n) {
                    if (i%3==0 && i%5 == 0) {
                        printFizzBuzz.run();
                        i++;
                        obj.notifyAll();
                    } else {
                        obj.wait();
                        
                    }
                }
            }
        }
    
        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            synchronized(obj) {
                while (i <= n) {
                    if (i%3!=0 && i %5 != 0) {
                        printNumber.accept(i);
                        i++;
                        obj.notifyAll();
                    } else {
                        obj.wait();
                        
                    }
                }
            }
        }
    }
}

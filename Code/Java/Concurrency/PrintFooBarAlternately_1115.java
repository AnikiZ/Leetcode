/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-12 22:04:55
 * @LastEditTime: 2022-11-12 22:17:55
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Concurrency/PrintFooBarAlternately_1115.java
 */
package Concurrency;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternately_1115 {
    
    // synchronized + 标志位 + 唤醒
    class FooBar_Synchronized {
        private int n;
        // 标志位，控制执行顺序，true执行printFoo，false执行printBar
        private volatile boolean type = true;
        private final Object foo=  new Object(); // 锁标志

        public FooBar_Synchronized(int n) {
            this.n = n;
        }
        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (foo) {
                    while(!type){
                        foo.wait();
                    }
                    printFoo.run();
                    type = false;
                    foo.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (foo) {
                    while(type){
                        foo.wait();
                    }
                    printBar.run();
                    type = true;
                    foo.notifyAll();
                }
            }
        }
    }
    class FooBar_Semaphore {
        private int n;
        private Semaphore foo = new Semaphore(1);
        private Semaphore bar = new Semaphore(0);
    
        public FooBar_Semaphore(int n) {
            this.n = n;
        }
    
        public void foo(Runnable printFoo) throws InterruptedException {
            
            for (int i = 0; i < n; i++) {
                foo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                bar.release();
            }
        }
    
        public void bar(Runnable printBar) throws InterruptedException {
            
            for (int i = 0; i < n; i++) {
                bar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                foo.release();
            }
        }
    }
}

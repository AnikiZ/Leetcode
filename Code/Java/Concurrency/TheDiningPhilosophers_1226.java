/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-12 17:46:12
 * @LastEditTime: 2022-11-12 17:46:13
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Multi_thread/TheDiningPhilosophers_1226.java
 */
package Concurrency;

import java.util.concurrent.Semaphore;

public class TheDiningPhilosophers_1226 {
    class DiningPhilosophers {
        public final Semaphore[] sema; //信号量数字组
    
        public DiningPhilosophers() {
            this.sema = new Semaphore[5];
            for (int i = 0; i < 5; i++) {
                this.sema[i] = new Semaphore(1); //每个信号初始化
    
            }
        }
    
        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int left = philosopher;
            int right = (philosopher + 1) % 5;//处理左右
            // 这样就不会出现死锁，即每个人都去拿右手边的叉子
            // 通过给每个人先选择哪个叉子构建优先级，防止死锁
            if (philosopher % 2 ==1) {
                // 奇数
                this.sema[left].acquire();
                this.sema[right].acquire();
            } else {
                // 偶数
                this.sema[right].acquire();
                this.sema[left].acquire();
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
    
            this.sema[left].release();
            this.sema[right].release();
    
        }
    }
}

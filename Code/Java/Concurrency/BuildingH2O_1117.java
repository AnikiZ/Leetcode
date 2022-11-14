/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-12 22:04:37
 * @LastEditTime: 2022-11-13 00:35:53
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Concurrency/BuildingH2O_1117.java
 */
package Concurrency;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
public class BuildingH2O_1117 {
    

    class H2O {
        private Semaphore hSema;
        private Semaphore oSema;
        private ConcurrentLinkedQueue<Runnable> hQueue;
        private ConcurrentLinkedQueue<Runnable> oQueue;
        private CyclicBarrier cb;

        public H2O() {
            hSema = new Semaphore(2);
            oSema = new Semaphore(1);
            hQueue = new ConcurrentLinkedQueue<>();
            oQueue = new ConcurrentLinkedQueue<>();
            // CyclicBarrier构造函数的第二个参数是回调函数，解释：
            // If the current thread is the last thread to arrive, 
            // and a non-null barrier action was supplied in the constructor,
            // then the current thread runs the action before allowing the other threads to continue. 
            cb = new CyclicBarrier(3, () -> {
                //满足屏障条件后，顺序运行
                hQueue.poll().run();
                hQueue.poll().run();
                oQueue.poll().run();
            });
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hSema.acquire();
            //未达到屏障条件，暂不运行
            hQueue.offer(releaseHydrogen);
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            //非交叉释放。
            //why： CyclicBarrier自动reset时，要求不能有其他await，否则抛异常 BrokenBarrierException
            hSema.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oSema.acquire();
            //未达到屏障条件，暂不运行
            oQueue.offer(releaseOxygen);
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            //非交叉释放。
            //why： CyclicBarrier自动reset时，要求不能有其他await，否则抛异常 BrokenBarrierException
            oSema.release();
        }
    }
}

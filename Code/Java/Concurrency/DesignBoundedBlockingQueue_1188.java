/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-13 00:40:51
 * @LastEditTime: 2022-11-13 00:41:52
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Concurrency/DesignBoundedBlockingQueue_1188.java
 */
package Concurrency;

import java.util.Deque;
import java.util.LinkedList;

public class DesignBoundedBlockingQueue_1188 {
    class BoundedBlockingQueue {
        public int cap;// 容量
        public int size;//实际大小
        public Deque<Integer>deque;
    
        public static Object obj = new Object();//元类型
    
        public BoundedBlockingQueue(int capacity) {
            this.cap =capacity;
            this.deque = new LinkedList<Integer>();
    
        }
        
        public void enqueue(int element) throws InterruptedException {
            synchronized(obj) { //线程安全
                while(this.size==this.cap) {
                    obj.wait();
                }
                this.deque.addLast(element);
                this.size++;
                obj.notify();// 通知其他人继续
            }
        }
        
        public int dequeue() throws InterruptedException {
            synchronized(obj) {
                while (this.size==0) {
                    obj.wait();
                }
                int ans = deque.pollFirst();
                this.size--;
                obj.notify();
                return ans;
            }
        }
        
        public int size() {
            return this.size;
        }
    }
}

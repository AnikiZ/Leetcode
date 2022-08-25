/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-12 23:02:40
 * @LastEditTime: 2022-08-12 23:24:19
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Collections/ImplementStackUsingQueues_225.java
 */
package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {
    // 其实用一个queue就行，push之前记录q的size，然后add新元素再把前面size个元素依次poll了add
    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        
        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }
        
        public int pop() {
            int ans = q1.poll();
            return ans;
        }
        
        public int top() {
            return q1.peek();
        }
        
        public boolean empty() {
            return q1.isEmpty();
        }
    }
    
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}

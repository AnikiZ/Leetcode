import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-08 19:11:26
 * @LastEditTime: 2022-08-08 20:06:45
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MinStack_155.java
 */
public class MinStack_155 {
    class MinStack {
        Deque<Integer> s1, min;
        public MinStack() {
            s1 = new LinkedList<Integer>();
            min = new LinkedList<Integer>();
        }
        
        public void push(int val) {
            if (min.isEmpty() || min.peek() >= val) {
                min.push(val);
            }
            System.out.println(min);
            s1.push(val);
        }
        
        public void pop() {
            // Integer类型不能用==！！！
            if (!min.isEmpty() && s1.pop().equals(min.peek())) {
                min.pop();
            }
            // System.out.println("min:" + min);
        }
        
        public int top() {
            return s1.peek();
        }
        
        public int getMin() {
            return min.peek();
        }
    }
    class MinStack_DIFF {
        Deque<Long> s;
        int min;
        public MinStack_DIFF() {
            s = new LinkedList<Long>();
        }
        
        public void push(int val) {
            if (s.isEmpty()) {
                min = val;
                // 0L!
                s.push((long)0);
            } else {
                long diff = (long)val - min;
                s.push(diff);
                min = Math.min(val, min);
            }
        }
        
        public void pop() {
            // Integer类型不能用==！！！
            if (s.isEmpty()) {
                return;
            }
            long diff = s.pop();
            if (diff < 0) {
                min = (int)(min - diff);
            }
        }
        
        public int top() {
            System.out.println(s.peek());
            return s.peek() < 0 ? min : (int)(min + s.peek());
        }
        
        public int getMin() {
            return min;
        }
    }
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}

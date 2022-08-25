/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-15 02:17:49
 * @LastEditTime: 2022-08-15 17:13:48
 * @LastEditors: Zeping Zhu
 * @Description:
 
 * @FilePath: /Code/Java/Collections/RangeSumQuery_MUtable_307.java
 */
package Collections;
 
public class RangeSumQuery_MUtable_307 {
    class NumArray_TimeExceeded {
        int[] pres;
        int[] nums;
        public NumArray_TimeExceeded(int[] nums) {
            pres = new int[nums.length + 1];
            this.nums = nums.clone();
            for (int i = 1; i <= nums.length; i++) {
                pres[i] = pres[i - 1] + nums[i - 1];
            }
        }
        
        public void update(int index, int val) {
            int diff = val - nums[index];
            for (int i = index + 1; i <= nums.length; i++) {
                pres[i] += diff;
            }
            nums[index] = val;
        }
        
        public int sumRange(int left, int right) {
            return pres[right + 1] - pres[left];
        }
    }


    // 上法优化为树状数组
    class NumArray_TreeArray {
        int[] tree;
        int[] nums;
        public NumArray_TreeArray(int[] nums) {
            this.nums = nums;
            // 加一是因为0的lowbit还是0，会陷入死循环！
            tree = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }
        public void update(int index, int val) {
            add(index + 1, val - nums[index]);
            nums[index] = val;
        }
        public int sumRange(int left, int right) {
            return query(right + 1) - query(left);
        }

        // log(n)
        public void add(int index, int val) {
            for (int x = index; x < tree.length; x += lowBit(x)) {
                tree[x] += val;
            }
        }
        public int query(int index) {
            int sum = 0;
            for (int i = index; i > 0; i -= lowBit(i)) {
                sum += tree[i];
            }
            return sum;
        }
        public int lowBit(int x) {
            return x & -x;
        }
    }
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */
}
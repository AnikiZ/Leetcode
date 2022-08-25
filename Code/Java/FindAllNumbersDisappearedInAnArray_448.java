import java.util.ArrayList;
import java.util.List;
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-06 22:03:47
 * @LastEditTime: 2022-08-06 22:12:18
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/FindAllNumbersDisappearedInAnArray_448.java
 */
public class FindAllNumbersDisappearedInAnArray_448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            for (int num : nums) {
                int pos = Math.abs(num) - 1;
                if (nums[pos] > 0) {
                    nums[pos] = -nums[pos];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }
}

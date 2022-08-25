/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-13 22:55:56
 * @LastEditTime: 2022-08-13 22:57:03
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Collections/ContainsDuplicate_217.java
 */
package Collections;

import java.util.HashSet;

public class ContainsDuplicate_217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-29 01:03:56
 * @LastEditTime: 2022-11-29 01:06:20
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/OA/ProfitTargets_TwoSumPro.java
 */
package OA;

import java.util.HashSet;
import java.util.Set;

// Given an int array nums and an int target,
// find how many unique pairs in the array such that their sum is equal to target. 
// Return the number of pairs.
public class ProfitTargets_TwoSumPro {
    public static int uniquePairs(int[] nums, int target){
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for(int num : nums){
            if(set.contains(target-num) && !seen.contains(num)){
                count++;
                seen.add(target-num);
                seen.add(num);
            }
            else if(!set.contains(num)){
                set.add(num);
            }

        }

        return count;
    }
}
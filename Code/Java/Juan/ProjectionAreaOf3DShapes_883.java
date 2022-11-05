/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-05 08:47:26
 * @LastEditTime: 2022-11-05 09:01:11
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Juan/ProjectionAreaOf3DShapes.java
 */
package Juan;

class Solution {
    public int projectionArea(int[][] grid) {
        int len = grid.length;
        int sumx = 0;
        int sumy = 0;
        int sumz = 0;
        for (int i = 0; i < len; i++) {
            sumz+=zero(grid[i]);
        }

        for (int j = 0; j < len; j++) {
            sumy += max(grid[j]);
        }

        for (int k = 0; k < len; k++) {
            int tmp = 0;
            for (int m = 0; m < len; m++) {
                if (grid[m][k] > tmp) {
                    tmp = grid[m][k];
                }
            }
            sumx+=tmp;
        }


        return sumx+sumy+sumz;
    }
    public int max(int[] arr) {
        int len = arr.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i]>result) {
                result=arr[i];
            }
        }
        return result;
    }

    public int zero(int[] arr) {
        int len = arr.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i]!=0) {
                result++;
            }
        }
        return result;
    }
    
}
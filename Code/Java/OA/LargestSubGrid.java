/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-29 01:51:30
 * @LastEditTime: 2022-11-29 02:00:03
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/OA/LargestSubGrid.java
 */
package OA;
public class LargestSubGrid {
    public class Solution {
        public static void main(String[] args) {
            int[][] grid = {{2,2,2},{3,3,3},{4,4,4}};
            System.out.println(Solution.largestSubgrid(grid, 14));
        }
        static int[][] preSum;
        public static int getSum(int row, int col) {
            if (row < 0 || col < 0 ) {
                return 0;
            } else {
                return preSum[row][col];
            }
        }
        public static int sumRegion(int row1, int col1, int row2, int col2) {
            return getSum(row2,col2) - getSum(row1-1,col2) - getSum(row2,col1-1) + getSum(row1-1,col1-1);
        }
        public static int largestSubgrid(int[][] grid, int k) {
            int n = grid.length;
            preSum = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    preSum[i][j] = getSum(i-1,j) + getSum(i,j-1) - getSum(i-1,j-1) + grid[i][j];
                }
            }
            int low = 0, high = n, ans = 0;
            while(low <= high){
                int mid = low + (high - low)/2;
                if(mid == 0)
                return 0;
                boolean stop = false;
                for(int i=mid-1; i<n && !stop; i++){
                    for(int j=mid-1; j<n && !stop; j++){
                        int subSum = sumRegion(i-mid+1,j-mid+1,i,j);
                        if(subSum > k){
                            stop = true;
                        }
                    }
                }
                if(stop){
                    high = mid - 1;
                }
                else{
                    ans = mid;
                    low = mid + 1;
                }
            }
            return ans;
        }
    }
}
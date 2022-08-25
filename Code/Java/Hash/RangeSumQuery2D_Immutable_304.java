/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-12 15:37:16
 * @LastEditTime: 2022-08-12 15:37:16
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Hash/RangeSumQuery2D_Immutable_304.java
 */
package Hash;

public class RangeSumQuery2D_Immutable_304 {
    class NumMatrix {
        int[][] rec;
        public NumMatrix(int[][] matrix) {
            int row = matrix.length, col = matrix[0].length;
            rec = new int[row + 1][col + 1];
            for (int i = 1; i < row + 1; i++) {
                for (int j = 1; j < col + 1; j++) {
                    rec[i][j] = matrix[i - 1][j - 1] + rec[i - 1][j] + rec[i][j - 1] - rec[i - 1][j - 1];
                }
            }
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return rec[row2 + 1][col2 + 1] - rec[row2 + 1][col1] - rec[row1][col2] + rec[row1][col1];
        }
    }
    
    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
}

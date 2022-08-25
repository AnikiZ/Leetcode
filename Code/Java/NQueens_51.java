import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-04 17:07:04
 * @LastEditTime: 2022-07-04 23:33:41
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/NQueens_51.java
 */
public class NQueens_51 {
    public static void main(String[] args) {
        System.out.println(Solution.solveNQueens(4));
    }
    class Solution {
        public static List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            boolean[] col = new boolean[n];
            boolean[] leftDiag = new boolean[2 * n - 1];
            boolean[] rightDiag = new boolean[2 * n - 1];
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            dfs(ans, col, leftDiag, rightDiag, 0, n, queens);
            return ans;
        }
        public static void dfs(List<List<String>> ans, boolean[] col, boolean[] leftDiag, boolean[] rightDiag, int row, int n, int[] queens) {
            if (row == n) {
                List<String> board = generateBoard(queens, n);
                ans.add(board);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (col[i] || leftDiag[n - (row - i) - 1] || rightDiag[row + i]) {
                    continue;
                }
                queens[row] = i;
                col[i] = true;
                leftDiag[n - (row - i) - 1] = true;
                rightDiag[row + i] = true;
                dfs(ans, col, leftDiag, rightDiag, row + 1, n, queens);
                queens[row] = -1;
                col[i] = false;
                leftDiag[n - (row - i) - 1] = false;
                rightDiag[row + i] = false;
            }
        }
        public static List<String> generateBoard(int[] queens, int n) {
            List<String> board = new ArrayList<>();
            for (int i : queens) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[i] = 'Q';
                board.add(new String(row));
            }
            return board;
        }
    }
}

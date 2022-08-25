import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-09 15:43:10
 * @LastEditTime: 2022-07-10 02:21:56
 * @LastEditors: Zeping Zhu
 * @Description: 错误原因：boolean find传入函数传的是值！在回溯的时候又变回了false，因此覆盖掉了正确答案！
 * 后续方法：启发式搜索，位运算优化，枚举优化等等。
 * @FilePath: /Code/Java/SudokuSolver_37.java
 */
public class SudokuSolver_37 {
    class Solution {
        // 错误原因：boolean find传入函数传的是值！在回溯的时候又变回了false，因此覆盖掉了正确答案！
        private static boolean find = false;
        public static void main(String[] args) {
            char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, 
        {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
            Solution.solveSudoku(board);
        }
        public static void solveSudoku(char[][] board) {
            
            boolean[][] rol = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][][] block = new boolean[3][3][9];
            List<int[]> points = new ArrayList<>();
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        points.add(new int[]{i,j});
                    } else {
                        int idx = board[i][j] - '0' - 1;
                        rol[i][idx] = col[j][idx] = block[i / 3][j / 3][idx] = true;
                    }
                }
            }
            dfs(board, rol, col, block, points, 0);
            System.out.println(Arrays.deepToString(board));
        }
        public static void dfs(char[][] board, boolean[][] rol, boolean[][] col, boolean[][][] block, List<int[]> points, int pos) {
            if (pos == points.size()) {
                find = true;
                return;
            }
            int[] point = points.get(pos);
            int x = point[0], y = point[1];
            for (int digit = 0; digit < 9 && !find; digit++) {
                if (!rol[x][digit] && !col[y][digit] && !block[x / 3][y / 3][digit]) {
                    rol[x][digit] = col[y][digit] = block[x / 3][y / 3][digit] = true;
                    board[x][y] = (char)('0' + digit + 1);
                    if (pos == 4 && digit == 0) {
                        System.out.println("here!");
                    }
                    if (pos == points.size() - 1) {
                        System.out.println("find!");
                    }
                    
                    dfs(board, rol, col, block, points, pos + 1);
                    
                    if (find == true) {
                        System.out.println("find is true!");
                    }
                    // 这句不需要！不然最后又变回原来的了！
                    // board[x][y] = '.';
                    rol[x][digit] = col[y][digit] = block[x / 3][y / 3][digit] = false;
                }
            }
        }
    }
}

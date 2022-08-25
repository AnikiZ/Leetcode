/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-07 23:05:23
 * @LastEditTime: 2022-07-07 23:25:44
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SurroundedRegions_130.java
 */
public class SurroundedRegions_130 {
    class Solution {
        public void solve(char[][] board) {
            int rol = board.length, col = board[0].length;
            for (int i = 0; i < rol; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0, rol, col);
                }
                if (board[i][col - 1] == 'O') {
                    dfs(board, i, col - 1, rol, col);
                }
            }
            for (int i = 0; i < col; i++) {
                if (board[0][i] == 'O') {
                    dfs(board, 0, i, rol, col);
                }
                if (board[rol - 1][i] == 'O') {
                    dfs(board, rol - 1, i, rol, col);
                }
            }
            for (int i = 0; i < rol; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                    // 错误！ 没加else!
                    // if (board[i][j] == 'O') {
                    //     board[i][j] = 'X';
                    // }

                }
            }
        }
        public void dfs(char[][] board, int i, int j, int rol, int col) {
            // 错误！ 也有可能为'A'！就会死循环
            // if (i < 0 || i >= rol || j < 0 || j >= col || board[i][j] == 'X') {
            //     return;
            // }
            if (i < 0 || i >= rol || j < 0 || j >= col || board[i][j] != 'O') {
                return;
            }
            board[i][j] = 'A';
            dfs(board, i + 1, j, rol, col);
            dfs(board, i - 1, j, rol, col);
            dfs(board, i, j + 1, rol, col);
            dfs(board, i, j - 1, rol, col);
        }
    }
}

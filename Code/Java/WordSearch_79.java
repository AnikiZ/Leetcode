/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-04 16:10:25
 * @LastEditTime: 2022-07-04 16:58:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/WordSearch_79.java
 */
public class WordSearch_79 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'}};
        String word = "ABCC";
        System.out.println(Solution.exist(board, word));
    }
    class Solution {
        public static boolean exist(char[][] board, String word) {
            int rol = board.length, col = board[0].length;
            boolean[][] visited = new boolean[rol][col];
            boolean result = false;
            for (int i = 0; i < rol; i++) {
                for (int j = 0; j < col; j++) {
                    result = dfs(i, j, rol, col, board, word, 0, visited);
                    if (result == true) {
                        return true;
                    }
                }
            }
            return result;
        }
        public static boolean dfs(int i, int j, int rol, int col, char[][] board, String word, int pos, boolean[][] visited) {
            if (i < 0 || i >= rol || j < 0 || j >= col) {
                return false;
            }
            if (visited[i][j] || board[i][j] != word.charAt(pos)) {
                return false;
            }
            if (pos == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            int[] dir = new int[]{-1, 0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {
                if (dfs(i + dir[k], j + dir[k + 1], rol, col, board, word, pos + 1, visited)) {
                    return true;
                }
            }
            visited[i][j] = false;
            return false;
        }
    }
}

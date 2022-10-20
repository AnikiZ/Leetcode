package Graph;
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-19 02:57:51
 * @LastEditTime: 2022-10-19 18:29:45
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/Graph/NumberOfProvinces_547.java
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean isVisited[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isVisited[i] == false) {
                dfs(i, isVisited, isConnected, n);
                count++;
            }
        }
        return count;
    }
    public void dfs(int i, boolean isVisited[], int[][] isConnected, int len) {
        for (int j = 0; j < len; j++) {
            if (isConnected[i][j]==1 && isVisited[j]==false) {
                isVisited[j]=true;
                dfs(j, isVisited, isConnected, len);
            }
        }
    }
}
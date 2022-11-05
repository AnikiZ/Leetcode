/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-05 09:22:32
 * @LastEditTime: 2022-11-05 11:29:36
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/DFS/ContainVirus_749.java
 */
package DFS;

public class ContainVirus_749 {
    public static void main(String[] args) {
        int[][] isInfected = new int[][]{{0,1,0,0,0,0,0,1}, {0,1,0,0,0,0,0,1}
        , {0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}};
        Solution sol = new Solution();
        sol.containVirus(isInfected);
    }
    static class Solution {
        int[][] isInfected;
        int[][] directs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        int curWall = 0; // 当前墙数量
        int row = 0;
        int col = 0;
        public Solution() {

        }
        public int containVirus(int[][] isInfected) {
            this.isInfected = isInfected;
            row = this.isInfected.length;
            col = this.isInfected[0].length;
            int result = 0;
            while(true) {
                int walls = getMaxAreaNeedWalls(isInfected);
                if (walls==0) {
                    break;
                }
                result += walls;
            }
            return result;
        }
        // 抓取最大范围需要的墙
        public int getMaxAreaNeedWalls(int[][] isInfected) {
            int maxArea = 0; //最大感染区
            int ans = 0; //需要墙的数量
            int targetX = -1;
            int targetY = -1; //DFS 开始遍历下标
            int state = -3; // 没有修建墙，maxArea+1,病毒不传染， DFS state-1
            int[][]visited = new int[row][col]; //是否访问过
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(isInfected[i][j]==1&&visited[i][j]==0) {
                        // 每次重置为0，表示一片新的病毒区域，是否上墙
                        curWall = 0;
                        int curMaxArea = dfs(visited,i,j,state);
                        if (curMaxArea > maxArea) {
                            maxArea = curMaxArea;
                            ans = curWall;
                            targetX = i;
                            targetY = j;
                        }
                        // 下一片的时候，state减减，这样检查威胁的时候，跟上次遍历的重叠
                        // 也可以算
                        state--;
                    
                    }
                    
                }
            }
            if(targetX==-1) {
                return 0;//没有病毒
            }
            modifyDead(targetX,targetY);
            visited = new int[row][col];
            for (int i =0; i<row;i++) {
                for (int j= 0; j < col; j++) {
                    if (isInfected[i][j]==1&&visited[i][j]==0) {
                        spread(visited,i,j);
                    }
                }
            }
            return ans;
        }
        public void spread(int[][]visited, int i, int j) {
            int curArea = 0;
            visited[i][j] = 1; // 记录走过
            for (int[] dir : directs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < row && y >= 0 && y < col && visited[x][y]!=1) {
                    if (isInfected[x][y]==0) {
                        isInfected[x][y] = 1;
                        visited[x][y] = 1;
                    } else if(isInfected[x][y]==1) {
                        spread(visited,x,y);
                    }
                }
            }
        }
        public void modifyDead(int x, int y) {
            isInfected[x][y]=-2;
            for (int[] dir : directs) {
                int newx = x + dir[0];
                int newy = y + dir[1];
                if (newx >= 0 && newx < row && newy >= 0 && newy < col && isInfected[newx][newy]==1) {
                    modifyDead(newx,newy);
                }
            }
        }
        public int dfs(int[][] visited, int i, int j, int state) {
            int curArea = 0;
            visited[i][j] = 1; // 记录走过
            for (int[] dir : directs) {
                int x = i + dir[0];
                int y = j + dir[1];
                // 同一个非感染砖块可以多次上墙，但在计算威胁度area时只能当做一个
                // 因此在visited里面state还要记录
                if (x >= 0 && x < row && y >= 0 && y < col && visited[x][y]!=1) {
                    if (isInfected[x][y]==0) {
                        // 加墙在感染和非感染之间
                        curWall++;
                        // 检查是否是之前上过墙的，那只用加墙，不算新的可扩张块
                        if(visited[x][y]!=state) {
                            curArea++;
                            visited[x][y]=state; //走过
                        }
                    } else if(isInfected[x][y]==1) {
                        visited[x][y]=state; //走过
                        curArea+=dfs(visited,x,y,state);
                    }
                }
            }
            return curArea;
        }
    }
}

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-14 02:47:52
 * @LastEditTime: 2022-11-14 03:35:25
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/RotatingTheBox_1861.java
 */
public class RotatingTheBox_1861 {
    class Solution_Queue {
        public char[][] rotateTheBox(char[][] box) {
            int m = box.length;
            int n = box[0].length;
            char[][] ans = new char[n][m];
            Deque<Integer> deque = new LinkedList<>();
            
            for (int i = 0; i< m; i++) {
                deque.clear();
                for (int j = n - 1; j >= 0; j--) {
                    if (box[i][j]=='*') {
                        deque.clear();
                    } else if (box[i][j]=='#') {
                        if (!deque.isEmpty()) {
                            int empty = deque.pollFirst();
                            box[i][empty] = '#';
                            box[i][j] = '.';
                            deque.add(j);
                        }
                    } else {
                        deque.add(j);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans[j][m - 1 - i] = box[i][j]; 
                }
            }
            
            return ans;
        }
    }
    class Solution {
        public char[][] rotateTheBox(char[][] box) {
            int m = box.length;
            int n = box[0].length;
            char[][] ans = new char[n][m];
            
            for (int i = 0; i< m; i++) {
                int empty = n-1;
                for (int j = n-1; j>=0; j--) {
                    if (box[i][j]=='*') {
                        empty = j-1;
                    } else if(box[i][j]=='#') {
                        if (empty > j) {
                            box[i][empty]='#';
                            empty--;
                            box[i][j]='.';
                        } else {
                            empty--;
                        }
                    }
    
                }
            }
            // rotate 90
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans[j][m - 1 - i] = box[i][j]; 
                }
            }
            
            return ans;
        }
    }
    class Solution_Brute {
        public char[][] rotateTheBox(char[][] box) {
            char ans[][]=new char[box[0].length][box.length];
            for(int i=0;i<box.length;i++){for(int j=0;j<box[0].length;j++){ans[j][box.length-1-i]=box[i][j];}}
            for(int j=0;j<ans[0].length;j++){
                for(int i=ans.length-1;i>=0;i--){
                    if(ans[i][j]=='#'){
                        for(int k=i+1;;k++){
                            if(k==ans.length||ans[k][j]!='.'){
                                ans[k-1][j]='#';
                                if(k!=i+1){ans[i][j]='.';}//只有在石头移动的时候才变空
                                break;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
}

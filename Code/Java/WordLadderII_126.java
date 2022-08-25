import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-07 16:43:52
 * @LastEditTime: 2022-07-07 17:47:02
 * @LastEditors: Zeping Zhu
 * @Description: public class WordLadderII_126 {
    
 }
 
 * @FilePath: /Code/Java/WordLadderII_126.java
 */
public class WordLadderII_126 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        Solution.findLadders("hit", "dot", wordList);
    }
    class Solution {
        public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<String>(wordList);
            Map<String, List<String>> map = new HashMap<>();
            Queue<String> queue = new ArrayDeque<String>();
            queue.add(beginWord);
            List<List<String>> ans = new ArrayList<>();
            if (!dict.contains(endWord)) {
                return ans;
            }
            dict.remove(beginWord);
            // bfs
            boolean find = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                // 每次遍历一层，逐层向下
                Set<String> visited = new HashSet<>();
                while (size-- != 0) {
                    String curr = queue.poll();
                    char[] c = curr.toCharArray();
                    int len = c.length;
                    for (int i = 0; i < len; i++) {
                        char old = c[i];
                        for (char j = 'a'; j <= 'z'; j++) {
                            if (j == old) {
                                continue;
                            }
                            c[i] = j;
                            String temp = new String(c);
                            if (dict.contains(temp)) {
                                if (temp.equals(endWord)) {
                                    find = true;
                                }
                                if (!visited.contains(temp)) {
                                    visited.add(temp);
                                    List<String> from = new ArrayList<>();
                                    from.add(curr);
                                    map.put(temp, from);
                                    queue.add(temp);
                                } else {
                                    List<String> from = map.get(temp);
                                    from.add(curr);
                                    map.put(temp, from);
                                }
                            }
                        }
                        c[i] = old;
                    }
                }
                for (String str : visited) {
                    dict.remove(str);
                }
                if (find) {
                    System.out.println("find!");
                    LinkedList<String> path = new LinkedList<>();
                    path.add(endWord);
                    dfs(ans, path, map, beginWord, endWord);
                    return ans;
                }
            }
            return ans;
        }
        public static void dfs(List<List<String>> ans, LinkedList<String> path, Map<String, List<String>> map, String target, String curr) {
            if (curr.equals(target)) {
                List<String> p = new ArrayList<>(path);
                ans.add(p);
                return;
            }
            List<String> temp = map.get(curr);
            for (String str : temp) {
                path.addFirst(str);
                dfs(ans, path, map, target, str);
                path.removeFirst();
            }
        }
    }
}
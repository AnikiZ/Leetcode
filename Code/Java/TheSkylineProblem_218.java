import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-09 15:52:58
 * @LastEditTime: 2022-08-09 17:09:18
 * @LastEditors: Zeping Zhu
 * @Description:
 * @FilePath: /Code/Java/TheSkylineProblem_218.java
 */
public class TheSkylineProblem_218 {
    class Solution {
        // 如果将所有的建筑的边界作为一条线，那么所有的答案都在这些线上
        // 考虑任意一条线，那么这条线和所有相交的建筑（这里排除掉刚好和建筑右边界相交），取一个最高的
        // 高度，然后判断这个高度是否和ans末尾最后一个元素的高度相等，不相等就加入进去
        // 在这里为了快速得到最高的高度，使用一个堆来进行记录
        
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> ans = new ArrayList<>();
            int[] boundaries = new int[buildings.length * 2];
            // 得到所有由建筑边界构成的边界线，并升序
            for (int i = 0; i < buildings.length; i++) {
                boundaries[i * 2] = buildings[i][0];
                boundaries[i * 2 + 1] = buildings[i][1];
            }
            Arrays.sort(boundaries);
            int buildNum = 0;
            // (rightbound, height)
            // 创建一个堆，维护一个右边界-高度值对
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)-> {
                return b[1] - a[1];
            });
            for (int boundary : boundaries) {
                // 对于一个建筑，如果其左边界在当前判断的边界线左边或重叠，那么向堆加入右边界-高度值对
                while (buildNum < buildings.length && buildings[buildNum][0] <= boundary) {
                    System.out.println(boundary + " " + buildings[buildNum][1] + " " + buildings[buildNum][2]);
                    queue.offer(new int[] {buildings[buildNum][1], buildings[buildNum][2]});
                    buildNum++;
                }
                // 对于那些加入了堆中的建筑，从堆的顶部移出建筑右边界在边界线左边或重叠的边界-高度值对
                while (!queue.isEmpty() && queue.peek()[0] <= boundary) {
                    queue.poll();
                }
                // 经过上面的两步操作之后，当前边界线穿过的建筑（不含右边界）全都在堆中，并且堆的顶端是所有穿过的建筑中，高度最高的，也就是天际线高度
                // 如果此时的堆为空，证明边界线没有穿过任何建筑，来到了建筑的分割位置，天际线为0
                int maxHeight = queue.isEmpty() ? 0 : queue.peek()[1];
                // 按照这种算法，每一条边界线都会产生一个天际线高度，如果这个高度和ans末尾元素的高度一致
                // 那么就说明两条边界线穿过了同一个建筑，并且相邻，那么按照规则只取最左端
                if (ans.size() == 0 || ans.get(ans.size() - 1).get(1) != maxHeight) {
                    ans.add(Arrays.asList(boundary, maxHeight));
                }
            }
            return ans;
        }
    }
}

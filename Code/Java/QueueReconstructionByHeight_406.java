import java.util.Arrays;
import java.util.Comparator;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-16 16:29:34
 * @LastEditTime: 2022-06-16 17:09:41
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /LeetCode/Code/Java/QueueReconstructionByHeight_406.java
 */
public class QueueReconstructionByHeight_406 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] person1, int[] person2) {
                    if (person1[0] != person2[0]) {
                        return person2[0] - person1[0];
                    } else {
                        return person1[1] - person2[1];
                    }
                }
            });
            // //新建一个list,用于保存结果集
            // List<int[]> list = new LinkedList<>();
            // for (int i = 0; i < people.length; i++) {
            //     if (list.size() > people[i][1]){
            //         //结果集中元素个数大于第i个人前面应有的人数时，将第i个人插入到结果集的 people[i][1]位置
            //         list.add(people[i][1],people[i]);
            //     }else{
            //         //结果集中元素个数小于等于第i个人前面应有的人数时，将第i个人追加到结果集的后面
            //         list.add(list.size(),people[i]);
            //     }
            // }
            // //将list转化为数组，然后返回
            // return list.toArray(new int[list.size()][]);
            int[][] ans = new int[people.length][2];
            for (int i = 0; i < people.length; i++) {
                if (people[i][1] == i) {
                    ans[i] = people[i];
                } else {
                    // 需要插入和右移
                    for (int j = i; j > people[i][1]; j--) {
                        ans[j] = ans[j - 1];
                    }
                    ans[people[i][1]] = people[i];
                }
            }
            return ans;
        }
    }
}

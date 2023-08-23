package OA.Mathworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfectPairs {
    public static void main(String[] args) {
        System.out.println(PerfectPairs.perfects(new int[]{-2, -3, 5}));
    }

    static long perfects(int[] a) {
        Map<Integer, Integer> have = new HashMap<>();
        for (int x : a) {
            have.put(Math.abs(x), have.getOrDefault(Math.abs(x), 0) + 1);
        }

        long num = 0, r = 0;
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(have.entrySet());
        entries.sort(Map.Entry.comparingByKey());

        int leftIndex = 0;

        for (Map.Entry<Integer, Integer> rightEntry : entries) {
            num += rightEntry.getValue();
            while (entries.get(leftIndex).getKey() * 2 < rightEntry.getKey()) {
                num -= entries.get(leftIndex).getValue();
                leftIndex++;
            }
            r += (num - rightEntry.getValue()) * rightEntry.getValue() + 
            // add its own cnts because same number pairs also valid
                 (rightEntry.getValue() - 1L) * rightEntry.getValue() / 2;
        }
        return r;
    }

}
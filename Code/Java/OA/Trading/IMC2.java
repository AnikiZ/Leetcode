package OA.Trading;

import java.util.ArrayDeque;
import java.util.Queue;

public class IMC2 {
    class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] res = new int[n];
        int time = 0;
        int prevState = 1;
        Queue<Integer> enter = new ArrayDeque<>();
        Queue<Integer> exit = new ArrayDeque<>();
        int pos = 0;
        while (pos < n || !enter.isEmpty() || !exit.isEmpty()) {
            while (pos < n && arrival[pos] <= time) {
                if (state[pos] == 0) {
                    enter.add(pos);
                } else {
                    exit.add(pos);
                }
                pos++;
            }
            if (!enter.isEmpty() || !exit.isEmpty()) {
                int type = exit.isEmpty() ? 0 : enter.isEmpty() ? 1 : prevState;
                prevState = type;
                if (type == 0) {
                    res[enter.poll()] = time;
                    time++;
                } else {
                    res[exit.poll()] = time;
                    time++;
                }
            } else {
                prevState = 1;
                time = arrival[pos];
            }
        }
        return res;
    }
}
}

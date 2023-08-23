package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet_380 {
    class RandomizedSet {
        List<Integer> list; 
        HashMap<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        public RandomizedSet() {
            this.list = new ArrayList<>();
            this.map = new HashMap<>();
        }
        
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.remove(val);
            int lastIndex = list.size() - 1;
            int lastVal = list.get(lastIndex);
            if (index != lastIndex) {
                list.set(index, lastVal);
                map.put(lastVal, index);
            }
            list.remove(lastIndex);
            return true;
        }
        
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
    
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}

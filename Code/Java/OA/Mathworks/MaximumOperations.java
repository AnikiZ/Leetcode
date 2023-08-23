package OA.Mathworks;

import java.util.HashMap;

public class MaximumOperations {

    public static int countSpecialSubstrings(String s) {
        HashMap<Character, Integer> ct = new HashMap<>();
        int res = 0;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            ct.put(s.charAt(i), ct.getOrDefault(s.charAt(i), 0) + 1);
            
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                res += n - i - ct.get(s.charAt(i));
                ct.clear();
                ct.put(s.charAt(i), n - i);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String s = "aabba";
        System.out.println(countSpecialSubstrings(s));
    }
}

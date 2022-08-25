public class ReverseBits_190 {
    public class Solution {
        // you need treat n as an unsigned value
        // In Java, there is no unsigned integer type.
        public int reverseBits(int n) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                ans |= ((n >> i) & 1 ) << (31 - i);
            }
            return ans;
        }
    }
}
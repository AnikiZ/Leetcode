'''
Author: Zeping Zhu
Andrew ID: zepingz
Date: 2022-06-15 14:35:00
LastEditTime: 2022-06-15 18:18:55
LastEditors: Zeping Zhu
Description: 
FilePath: /LeetCode/Code/Python/76_MinimumWindowSubstring.py
'''
# Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
# such that every character in t (including duplicates) is included in the window. 
# If there is no such substring, return the empty string "".

# The testcases will be generated such that the answer is unique.

# A substring is a contiguous sequence of characters within the string.

# Constraints:
# m == s.length
# n == t.length
# 1 <= m, n <= 105
# s and t consist of uppercase and lowercase English letters.
import collections

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = collections.defaultdict(int)
        for c in t:
            need[c] += 1
        needCnt = len(t)
        i = 0
        res = (0, float('inf'))
        for index, char in enumerate(s):
            if need[char] > 0:
                # 用减法，只需要一个dict储存，空间少，但逻辑更复杂
                needCnt -= 1
            need[char] -= 1
            # 1: window contains all characters
            if needCnt == 0:
                # 2: add i to exclude redundant elements
                while need[s[i]] != 0:
                    need[s[i]] += 1
                    i += 1
                # 3: update the range
                if index - i < res[1] - res[0]:
                    res = (i, index)
                # 4: the element in left index i must be the necessary element
                need[s[i]] += 1
                # 5: add left index i to find next window
                i += 1
                needCnt += 1
        return '' if res[1] > len(s) else s[res[0] : res[1] + 1]

if __name__=="__main__":
    sol = Solution()
    s = 'aaa'
    t = 'aa'
    ans = sol.minWindow(s, t)
    print (ans)

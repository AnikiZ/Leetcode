'''
Author: Zeping Zhu
Andrew ID: zepingz
Date: 2022-07-24 01:19:50
LastEditTime: 2022-07-24 01:27:55
LastEditors: Zeping Zhu
Description: 
FilePath: /Code/Python/643MaximumLengthOfPairChain.py
'''
from typing import List


class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        def bin_search(target): # 寻找右元素大于target的数对位置
            R = len(up_stack)
            L = 0
            while L < R:
                mid = (L + R) // 2
                mid_val = up_stack[mid][1]
                if mid_val >= target:
                    R = mid
                else:
                    L = mid + 1
            return L

        pairs.sort()
        up_stack = [pairs[0]]
        print("up_stack: ", up_stack)
        n = len(pairs)

        for i in range(1, n):
            ids = bin_search(pairs[i][1])
            if ids == len(up_stack): # 如果当前数对右元素是最大的，则考虑是否增加长度
                if up_stack[-1][1] < pairs[i][0]:
                    up_stack.append(pairs[i])
            else:
                up_stack[ids] = pairs[i] # 利用右元素更小的替换
        return len(up_stack)
if __name__=="__main__":
    pairs = [[1,2], [3,4], [6, 7]]
    sol = Solution()
    print (sol.findLongestChain(pairs))
'''
Author: Zeping Zhu
Andrew ID: zepingz
Date: 2022-07-01 21:31:49
LastEditTime: 2022-07-24 01:17:47
LastEditors: Zeping Zhu
Description: 
FilePath: /Code/Python/test.py
'''
if __name__=="__main__":
    visited1 = set()
    visited1 = {(2, 3), (0, 1)}
    visited1.add((1, 2))
    print(visited1)
    visited2 = set()
    visited2.add((1, 2))
    visited2.add((2, 3))
    print(visited2)
    a = visited1 & visited2
    b = list(map(list, a))
    print(a)
    print(b)

    pairs = [[1, 2], [2, 3]]
    up_stack = [pairs[0]]
    mid_val = up_stack[1][1]
    print(mid_val)
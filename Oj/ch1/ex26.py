#coding: utf-8
"""
    sort3letters.py
    ```````````````

    给3个字母排序
"""

def sort3letters(a, b, c):
    # 22进行比较一次, 即可完成排序
    if (a > b):
        t = a
        a = b; b = t
    if (a > c):
        t = a
        a = c; c = t
    if (b > c):
        t = b
        b = c; c = t
    return (a, b, c)

if __name__ == '__main__':
    print(sort3letters(3, 4, 1))

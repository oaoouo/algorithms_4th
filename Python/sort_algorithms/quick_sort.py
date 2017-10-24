#coding: utf-8
# 快速排序


import random


def quick_sort(l):
    """
    a[start, mid-1] a[mid] a[mid+1, end]
    算法时间复杂度是O(NlogN)
    """
    random.shuffle(l)
    sort(l, 0, len(l)-1)


def sort(l, start, end):
    if (start >= end): return
    mid = partition(l, start, end)
    sort(l, start, mid-1) # mid-1
    sort(l, mid+1, end)


def partition(l, start, end):
    v = l[start]
    i = start; j = end
    while (True):
        while (l[i] <= v and i < end): i += 1
        while (l[j] >= v and j > start): j -= 1
        if (i >= j): break
        exchange(l, i, j)
        i += 1; j -= 1 
    exchange(l, start, j)  # l[j] < v
    return j


def exchange(l, i, imin):
    temp = l[i]
    l[i] = l[imin]
    l[imin] = temp


if __name__ == '__main__':
    l = [1, 5, 3, 6, 8, 9, 10, 200, 45, 8, 100, 2, -1, 200, 0.5]
    quick_sort(l)
    print(l)

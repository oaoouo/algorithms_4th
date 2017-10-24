#coding: utf-8
# 归并排序

import copy


def merge(l, start, mid, end):
    i = start; j = mid+1; k = start
    ltemp = copy.deepcopy(l)
    for k in range(start, end+1):
        if (i > mid):
            l[k] = ltemp[j]; j += 1
        elif (j > end):
            l[k] = ltemp[i]; i += 1
        elif (ltemp[i] > ltemp[j]):
            l[k] = ltemp[j]; j += 1
        else:
            l[k] = ltemp[i]; i += 1


def from_up_2_bottom(l):
    """
    自顶向下的归并排序
    算法的时间复杂度: O(NlogN)
    """
    merge_sort(l, 0, len(l)-1)


def merge_sort(l, start, end):
    if (start >= end): return  # merge([1], [2]) -> [1, 2]
    mid = start + (end-start) / 2
    merge_sort(l, start, mid)
    merge_sort(l, mid+1, end)
    merge(l, start, mid, end)  # 排序


def from_bottom_2_up(l):
    """
    自底向上的归并排序
    算法的时间复杂度: O(NlogN)
    """
    sz = 1
    while (sz < len(l)):
        i = 0  # 注意i是从0开始的
        while (i < len(l)):
            merge(l, i, i+sz-1, min(i+sz+sz-1, len(l)-1))
            i += (sz + sz)
        sz += sz


if __name__ == '__main__':
    l1 = [1, 5, 3, 6, 8, 9, 10, 200, 45, 8, 100, 2]
    l2 = [1, 5, 3, 6, 8, 9, 10, 200, 45, 8, 100, 2]
    from_up_2_bottom(l1)
    from_bottom_2_up(l2)
    print(l1)
    print(l2)

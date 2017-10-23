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
    先分再合
    """
    merge_sort(l, 0, len(l)-1)


def merge_sort(l, start, end):
    if (start >= end): return  # merge([1], [2]) -> [1, 2]
    mid = start + (end-start) / 2
    merge_sort(l, start, mid)
    merge_sort(l, mid+1, end)
    merge(l, start, mid, end)  # 排序


if __name__ == '__main__':
    l = [1, 5, 3, 6, 8, 9, 10, 200, 45]
    from_up_2_bottom(l)
    print(l)

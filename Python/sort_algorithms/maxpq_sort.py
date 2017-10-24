#coding: utf-8
# 堆排序


def exchange(l, i, j):
    temp = l[i]
    l[i] = l[j]
    l[j] = temp


def sink(l, k, N):
    while (2*k < N-1):
        if (l[2*k] > l[2*k+1]):
            maxsub= 2*k
        else: maxsub = 2*k + 1
        if (l[k] < l[maxsub]):
            exchange(l, k, maxsub)
            k = maxsub
        else: break


def maxpq_sort(l):
    """
    堆排序分为两个逻辑单元
    -- 1. 利用sink构造堆
    -- 2. 不断返回堆中优先级最高的元素达到排序的目的
    算法的时间复杂度: O(NlogN)
    算法的空间复杂度: O(M) # M是最优先的M个元素
    """
    N = len(l)
    k = N/2  # 从根节点就可以构造堆
    # 构造堆
    while (k >= 1):
        sink(l, k, N)
        k -= 1
    while (N > 1):
        N -= 1
        exchange(l, 1, N)
        sink(l, 1, N)


if __name__ == '__main__':
    l = [5, 3, 6, 8, 9, 10, 200, 45, 8, 100, 2, -1, 200, 0.5]
    l = [None] + l  # 因为堆的第0个元素是不参与堆构造的
    maxpq_sort(l)
    l = l[1:]
    print(l)

#coding: utf-8
# 基于堆的优先队列


class MaxPQ(object):

    def __init__(self, size):
        self.N = 0
        self.maxN = size+1  # pq[0]不用于构造堆
        self.pq = [None for _ in range(self.maxN)]

    def is_empty(self):
        return self.N == 0

    def size(self):
        return self.N

    def insert(self, k):
        """向堆中插入一个元素"""
        self.N += 1
        self.pq[self.N] = k
        self.__swim__(self.N)

    def delMax(self):
        """删除并返回堆中最优先元素"""
        m = self.pq[1]
        self.__exchange__(1, self.N)
        self.__sink__(1)
        self.N -= 1
        return m

    def __exchange__(self, i, j):
        """交换位置i和位置j的元素"""
        temp = self.pq[i]
        self.pq[i] = self.pq[j]
        self.pq[j] = temp

    def __swim__(self, i):
        """将i位置的元素上浮到堆中合适的位置"""
        while (self.pq[i] > self.pq[i/2] and i > 1):
            self.__exchange__(i, i/2)
            i = i/2  # __iter__

    def __sink__(self, k):
        """将k位置的元素下沉到堆中合适的位置"""
        while(2*k < self.N):
            if (self.pq[2*k] > self.pq[2*k+1]):
                maxsub = 2*k
            else: maxsub = 2*k + 1
            if (self.pq[k] < self.pq[maxsub]):
                self.__exchange__(k, maxsub)
                k = maxsub  # __iter__
            else: break


if __name__ == '__main__':
    maxpq = MaxPQ(10)
    for i in range(10):
        maxpq.insert(i)
    print(maxpq.pq)
    print(maxpq.delMax())
    maxpq.insert(10)
    print(maxpq.pq)
    print(maxpq.delMax())
    print(maxpq.pq)

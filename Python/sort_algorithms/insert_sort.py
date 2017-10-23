#coding: utf-8
# 插入排序


def exchange(l, i, imin):
    temp = l[i]
    l[i] = l[imin]
    l[imin] = temp


def insert_sort(l):
    """
    插入排序考虑到了输入特征, 而且输入内排序越多插入排序的效率越高;
    算法的时间复杂度: O(N^2) {最坏情况下}
    """
    for i in range(1, len(l)):  # 摸牌
        for j in range(i, 0, -1):
            if (l[j] < l[j-1]):
                exchange(l, j-1, j)
            continue


if __name__ == '__main__':
    l = [1, 5, 3, 6, 8, 9, 10, 200, 45, 3, 4]
    insert_sort(l)
    print(l)

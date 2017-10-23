#coding: utf-8
# 选择排序


def exchange(l, i, imin):
    temp = l[i]
    l[i] = l[imin]
    l[imin] = temp


def select_sort(l):
    """
    select sort与输入无关, 即使输入已经排序完成, select_sort依然会进行排序,
    而且因为无法一趟获取输入是否已排序信息, 所以无法向冒泡排序一样设置flag.
    算法时间复杂度: O(N^2)
    """
    for i in range(len(l)):
        m = l[i]
        imin = i
        for j in range(i+1, len(l)):
            if (l[j] < m):
                m = l[j]
                imin = j
        exchange(l, i, imin)


if __name__ == '__main__':
    l = [1, 5, 3, 6, 8, 9, 10, 200, 45]
    select_sort(l)
    print(l)

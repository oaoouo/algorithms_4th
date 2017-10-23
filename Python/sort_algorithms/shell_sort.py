#coding: utf-8
# 希尔排序


def exchange(l, i, imin):
    temp = l[i]
    l[i] = l[imin]
    l[imin] = temp


def shell_sort(l):
    """
    希尔排序的关键就是构造k有序子数组,
    一开始问题规模减小, 插入排序效率较高;
    随着希尔排序的进行, 虽然问题规模变大, 但是内排序增多, 插入排序依然维持着高效率;
    算法时间复杂度(3有序子数组) O(N^(3/2))
    """
    # 构造h有序子数组索引
    h = 1
    while (3*h < len(l)):
        h = 3*h + 1
    # 进行希尔排序
    while (h > 0):
        for i in range(h, len(l)):
            for j in range(i, 0, -h):
                if (l[j] < l[j-h]):
                    exchange(l, j, j-h)
                continue
        h = h/3
        

if __name__ == '__main__':
    l = [1, 5, 3, 6, 8, 9, 10, 200, 45, 3, 4]
    shell_sort(l)
    print(l)

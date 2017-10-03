#coding: utf-8

"""
也可以用双向循环链表来解决, 不过时间复杂度是o(n*m)
"""

def josephus_1(n, m):
    # 采用递推式求解
    # f(n) = (f(n-1)+m) mod n
    result = 0  # 只有一个人, 编号从0开始
    for i in range(n):
        # 递推至n个人
        result = (result + m) % (i+1)
    return result


def josephus_2(n, m):
    # 每一轮报完floor(n/m)*m个人后进行递归
    # 这样递归规模每次就不仅仅是n-1, 而是n-n/m
    # 从而减少递归调用的次数. 将问题的时间复杂度由o(n)减少至o(logn)
    if (n==1):
        return 0
    if (n < m):
        # 此时第一轮报数无法删除人数
        # 所以采用n-1规模的递归解决问题
        return (josephus_2(n-1, m) + m) % n
    result = josephus_2(n-n/m, m) - n%m
    if (result < 0):
        return result + n  # 上一轮最后被删除元素后的编号变换
    return result + result/(m-1) # 上一轮最后被删除元素前的编号变化


if __name__ == '__main__':
    print(josephus_1(41, 3))
    print(josephus_2(int('1'*100), 3))

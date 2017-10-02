#coding: utf-8


def josephus_1(n, m):
    # 采用递推式求解
    # f(n) = (f(n-1)+m) mod n
    result = 0  # 只有一个人, 编号从0开始
    for i in range(n):
        # 递推至n个人
        result = (result + m) % (i+1)
    return result


def josephus_2(n, m):
    if (n==1):
        return 0
    if (n < m):
        return (josephus_2(n-1, m) + m) % n
    result = josephus_2(n-n/m, m) - n%m
    if (result < 0):
        return result + n
    return result + result/(m-1)


if __name__ == '__main__':
    print(josephus_1(41, 3))
    print(josephus_2(int('1'*100), 3))

#coding: utf-8

def gcd(i, j):
    # i > j
    if (j == 0):
        return i
    return gcd(j, i%j)

def isPrime(i, j):
    # 判断i, j是否互质
    n = gcd(i, j) if i > j else gcd(j, i)
    if (n == 1):
        return True
    else: False


def cMatrix(N):
    # 创建一个NxN方阵
    # a[i][j] = True (i, j互质时) 否则为False
    a = range(N)
    for i in range(len(a)):
        a[i] = [0]*N
    for i in range(N):
        for j in range(N):
            if isPrime(i, j):
                a[i][j] = True
            else: a[i][j] = False
    return a
                

if __name__ == '__main__':
    N = 4
    print(cMatrix(N))

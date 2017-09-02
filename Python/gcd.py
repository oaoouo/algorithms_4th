#coding: utf-8

def gcd(a, b):
    # a > b
    if (b == 0):
        return a
    return gcd(b, a % b)

if __name__ == '__main__':
    a = 10 ; b = 4
    print(gcd(a, b))

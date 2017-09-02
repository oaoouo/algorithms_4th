#coding: utf-8

def sqrt(a):
    # 求数a的平方根
    x = a
    e = 1e-20
    while ((x*x-a) > e): 
        x = (x*x+a)/(2*x)
    if (x*x == a):
        return x
    else: return -1

if __name__ == '__main__':
    print("4: %s" % sqrt(4))
    print("15: %s" % sqrt(15))
    print("100: %s" % sqrt(100))
    print("144: %s" % sqrt(144))

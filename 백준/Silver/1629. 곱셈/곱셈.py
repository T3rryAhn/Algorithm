import sys

a, b, c = map(int,sys.stdin.readline().split())

def power(a, b):
    if b == 0:
        return 1

    if b % 2 == 0:
        temp = power(a, b // 2) % c
        return temp * temp
    else:
        temp = power(a, (b - 1) // 2) % c
        return temp * temp * a % c


result = power(a, b) % c
print(result)


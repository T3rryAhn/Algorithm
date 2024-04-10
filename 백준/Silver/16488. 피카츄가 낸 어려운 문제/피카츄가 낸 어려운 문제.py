import sys

N, K = map(int, sys.stdin.readline().split())

ab_square = N * N
mid = (1 + K) / 2


def F(i):
    return ab_square - 2*mid*i + i**2 + i*(K + 1 - i)


result = 0
for i in range(1, K + 1):
    result += F(i)

print(int(result))

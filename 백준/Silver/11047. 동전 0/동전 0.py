import sys

n, k = map(int, sys.stdin.readline().split())

coins = [int(sys.stdin.readline()) for _ in range(n)]

result = 0
for coin in coins[::-1]:
    if k == 0:
        break

    if k >= coin:
        result += k // coin
        k = k % coin

print(result)

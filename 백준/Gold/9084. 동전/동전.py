import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    coins = list(map(int, sys.stdin.readline().split()))
    target = int(sys.stdin.readline())
    costs = [0 for _ in range(target + 1)]
    costs[0] = 1

    for coin in coins[::-1]:
        for cost, case in enumerate(costs):
            a = cost - coin
            if a >= 0:
                costs[cost] += costs[a]

    print(costs[-1])

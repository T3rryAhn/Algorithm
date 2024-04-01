import sys

n = int(sys.stdin.readline())
weights = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
marbles = list(map(int, sys.stdin.readline().split()))
# max_weight = max(marbles)
max_weight = sum(weights)
dp = [False] * (max_weight + 1)

for weight in weights:
    temp = []
    for i in range(max_weight, 0, -1):
        if dp[i]:
            temp.append(abs(i - weight))
            if i + weight <= max_weight:
                temp.append(i + weight)

    if weight <= max_weight:
        temp.append(weight)

    for w in temp:
        dp[w] = True

for marble in marbles:
    if marble > max_weight:
        print('N', end=' ')
    else:
        if dp[marble]:
            print('Y', end=' ')
        else:
            print('N', end=' ')

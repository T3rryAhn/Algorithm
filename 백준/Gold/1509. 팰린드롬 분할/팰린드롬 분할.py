import sys

arr = ['0'] + list(sys.stdin.readline().strip())
n = len(arr)
dp = [[0 for _ in range(n)] for _ in range(n)]
INF = sys.maxsize
result = [0 for _ in range(n)]

for i in range(1, n):
    dp[i][i] = 1

for i in range(1, n - 1):
    if arr[i] == arr[i + 1]:
        dp[i][i + 1] = 2

for length in range(3, n):
    for j in range(3, n):
        i = j - length + 1
        if arr[i] == arr[j]:
            if dp[i + 1][j - 1]:
                dp[i][j] = length

result[1] = 1
for e in range(2, n):
    result[e] = result[e - 1] + 1
    for s in range(1, e):
        if dp[s][e]:
            result[e] = min(result[s - 1] + 1, result[e])

print(result[-1])
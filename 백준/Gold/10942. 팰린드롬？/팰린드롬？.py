import sys

n = int(sys.stdin.readline())
arr = [0] + list(map(int, sys.stdin.readline().split()))

dp = [[0 for _ in range(n + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    dp[i][i] = 1

for i in range(1, n):
    if arr[i] == arr[i + 1]:
        dp[i][i + 1] = 1
    else:
        dp[i][i + 1] = 0

for length in range(3, n + 1):
    for j in range(3, n + 1):
        i = j - length + 1
        if arr[i] == arr[j]:
            if dp[i + 1][j - 1] == 1:
                dp[i][j] = 1

# for a in dp:
#     print(a)

m = int(sys.stdin.readline())
for _ in range(m):
    s, e = map(int, sys.stdin.readline().split())
    print(dp[s][e])
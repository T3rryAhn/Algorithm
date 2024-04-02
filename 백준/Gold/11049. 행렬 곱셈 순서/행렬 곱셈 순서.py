import sys

n = int(sys.stdin.readline())
matrices = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]

dp = [[0 for _ in range(n)] for _ in range(n)]

for chain_len in range(2, n + 1):
    for i in range(n - chain_len + 1):
        j = i + chain_len - 1
        dp[i][j] = sys.maxsize
        for k in range(i, j):
            cost = dp[i][k] + dp[k + 1][j] + matrices[i][0] * matrices[k][1] * matrices[j][1]
            dp[i][j] = min(dp[i][j], cost)

print(dp[0][n - 1])

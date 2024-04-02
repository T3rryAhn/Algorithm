import sys

n, m = map(int, sys.stdin.readline().split())

grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dp = [[0] * m for _ in range(n)]

# 첫번째행 초기화
dp[0][0] = grid[0][0]
for x in range(1, m):
    dp[0][x] = dp[0][x - 1] + grid[0][x]

for y in range(1, n):
    left = [0] * m
    right = [0] * m

    # 왼쪽에서 오른 쪽으로
    left[0] = dp[y - 1][0] + grid[y][0]
    for x in range(1, m):
        left[x] = max(left[x - 1], dp[y - 1][x]) + grid[y][x]

    # 오른에서 왼
    right[-1] = dp[y - 1][-1] + grid[y][-1]
    for x in range(m - 2, -1, -1):
        right[x] = max(right[x + 1], dp[y - 1][x]) + grid[y][x]

    for x in range(m):
        dp[y][x] = max(left[x], right[x])


print(dp[-1][-1])

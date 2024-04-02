import sys

n, m = map(int, input().split())

grid = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * m for _ in range(n)]

# 첫 번째 행 초기화
for x in range(m):
    dp[0][x] = dp[0][x - 1] + grid[0][x] if x > 0 else grid[0][x]

for y in range(1, n):
    left = [0] * m
    right = [0] * m
    
    # 왼쪽에서 오른쪽으로
    left[0] = dp[y - 1][0] + grid[y][0]
    for x in range(1, m):
        left[x] = max(left[x - 1], dp[y - 1][x]) + grid[y][x]

    # 오른쪽에서 왼쪽으로
    right[m - 1] = dp[y - 1][m - 1] + grid[y][m - 1]
    for x in range(m - 2, -1, -1):
        right[x] = max(right[x + 1], dp[y - 1][x]) + grid[y][x]

    # 최댓값 결정
    for x in range(m):
        dp[y][x] = max(left[x], right[x])

print(dp[n - 1][m - 1])
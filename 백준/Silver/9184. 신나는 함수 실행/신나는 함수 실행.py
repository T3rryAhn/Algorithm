import sys


dp = [[[0 for _ in range(21)] for _ in range(21)] for _ in range(21)]

for a in range(21):
    for b in range(21):
        for c in range(21):
            if a <= 0 or b <= 0 or c <= 0:
                dp[a][b][c] = 1

for a in range(1, 21):
    for b in range(1, 21):
        for c in range(1, 21):

            if a > 20 or b > 20 or c > 20:
                dp[a][b][c] = dp[20][20][20]

            if a < b < c:
                dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c]

            else:
                dp[a][b][c] = dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1]


while True:
    i, j, k = map(int, sys.stdin.readline().split())
    if [i, j, k] == [-1, -1, -1]:
        break

    if i <= 0 or j <= 0 or k <= 0:
        print(f'w({i}, {j}, {k}) = 1')

    elif i > 20 or j > 20 or k > 20:
        print(f'w({i}, {j}, {k}) = {dp[20][20][20]}')

    else:
        print(f'w({i}, {j}, {k}) = {dp[i][j][k]}')



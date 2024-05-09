import sys
from sys import stdin

N = int(stdin.readline())
graph = [list(map(int, stdin.readline().split())) for _ in range(N)]
result = "Hing"

d_row, d_col = (1, 0), (0, 1)


def can_jump(row, col):
    return 0 <= row < N and 0 <= col < N


def jump(row, col):
    global result

    if (row, col) == (N - 1, N - 1):
        result = "HaruHaru"
        return

    if graph[row][col] == 0:
        return

    for i in range(2):
        n_row = row + d_row[i] * graph[row][col]
        n_col = col + d_col[i] * graph[row][col]
        if can_jump(n_row, n_col):
            jump(n_row, n_col)


jump(0, 0)
print(result)

import sys

sys.setrecursionlimit(10 ** 8)

n = int(sys.stdin.readline())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
max_height = max([max(grid[i]) for i in range(n)])

dx = (-1, 0, 1, 0)
dy = (0, -1, 0, 1)


def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


def dfs(x, y, i, visited):

    def _dfs(x, y, water):

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if in_range(nx, ny) and not visited[nx][ny] and grid[nx][ny] > water:
                visited[nx][ny] = True
                _dfs(nx, ny, water)

    _dfs(x, y, i)


max_count = 1
for i in range(1, max_height):
    count = 0
    visited_a = [[False for _ in range(n)] for _ in range(n)]

    for x in range(n):
        for y in range(n):
            if not visited_a[x][y] and grid[x][y] > i:
                dfs(x, y, i, visited_a)
                count += 1

    max_count = max(max_count, count)

print(max_count)

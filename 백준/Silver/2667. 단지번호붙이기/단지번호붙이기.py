import sys

n = int(sys.stdin.readline())

grid = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
visited = [[False for _ in range(n)] for _ in range(n)]

dx = (-1, 0, 1, 0)
dy = (0, -1, 0, 1)


def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


def dfs(x, y):
    count = 0

    def _dfs(x, y):
        nonlocal count
        count += 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if in_range(nx, ny) and grid[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                _dfs(nx, ny)

    visited[x][y] = True
    _dfs(x, y)

    return count


result = []

for x in range(n):
    for y in range(n):
        if grid[x][y] == 1 and not visited[x][y]:
            result.append(dfs(x, y))

result.sort()
print(len(result))

for i in result:
    print(i)
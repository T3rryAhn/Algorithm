import sys
from collections import deque

n = int(sys.stdin.readline())
grid = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
INF = sys.maxsize

destroyed = [
    [sys.maxsize] * n
    for _ in range(n)
]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def in_range(x, y):
    return 0 <= x and x < n and 0 <= y and y < n


def bfs(x, y, c):
    queue = deque()
    queue.append((x, y, c))
    destroyed[x][y] = 0
    while queue:
        x, y, c = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if in_range(nx, ny):
                if grid[nx][ny] and destroyed[nx][ny] > c:
                    destroyed[nx][ny] = c
                    queue.append((nx, ny, c))
                elif not grid[nx][ny] and destroyed[nx][ny] > c + 1:
                    destroyed[nx][ny] = c + 1
                    queue.append((nx, ny, c + 1))


bfs(0, 0, 0)
print(destroyed[n - 1][n - 1])

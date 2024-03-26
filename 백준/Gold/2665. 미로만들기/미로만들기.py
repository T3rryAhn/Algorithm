import sys
from collections import deque

n = int(sys.stdin.readline())
maze = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
INF = sys.maxsize
destroyed = [[sys.maxsize] * n for _ in range(n)]
dx = (-1, 0, 1, 0)
dy = (0, -1, 0, 1)

def in_range(x, y):
    return 0 <= x < n and 0 <= y < n

def bfs():
    queue = deque()
    queue.append((0, 0, 0))
    destroyed[0][0] = 0

    while queue:
        x, y, d = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            temp_d = d

            if in_range(nx, ny):
                if maze[nx][ny] == 0:
                    temp_d += 1
                if destroyed[nx][ny] > temp_d:
                    destroyed[nx][ny] = temp_d
                    queue.append((nx, ny, temp_d))



bfs()

print(destroyed[n - 1][n - 1])
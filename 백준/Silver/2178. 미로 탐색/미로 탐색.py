import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
maze = [list(map(int, input().strip())) for _ in range(N)]

INF = sys.maxsize
cost = [[INF] * M for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def in_range(x, y):
    return 0 <= x < M and 0 <= y < N


def bfs(x, y, c):
    queue = deque()
    queue.append((x, y, c))
    cost[0][0] = 1

    while queue:
        x, y, c = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if in_range(nx, ny) and maze[ny][nx] == 1:
                if cost[ny][nx] > c + 1:
                    queue.append((nx, ny, c + 1))
                    cost[ny][nx] = c + 1


bfs(0, 0, 1)

print(cost[N - 1][M - 1])

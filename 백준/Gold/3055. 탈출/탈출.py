import sys
from collections import deque

dx = (-1, 0, 1, 0)
dy = (0, -1, 0, 1)


def in_range(x: int, y: int) -> bool:
    return 0 <= x < c and 0 <= y < r


def bfs_flood(starts: list):
    queue = deque()
    for start in starts:
        queue.append(start)

    while queue:
        x, y, time = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if in_range(nx, ny):
                if forest_map[ny][nx] == '.' or forest_map[ny][nx] == 'S':
                    queue.append((nx, ny, time + 1))
                    forest_map[ny][nx] = time


def bfs_dochi(start):
    queue = deque()
    queue.append(start)
    forest_map[start[1]][start[0]] = '🦔'
    while queue:
        x, y, time = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if in_range(nx, ny):
                if (nx, ny) == D:
                    return time
                elif forest_map[ny][nx] == '.' or (
                                str(forest_map[ny][nx]).isdigit() and int(forest_map[ny][nx]) > time):
                    queue.append((nx, ny, time + 1))
                    forest_map[ny][nx] = '🦔'
    return 'KAKTUS'


r, c = map(int, sys.stdin.readline().split())
forest_map = []
D = (None, None)
S = (None, None, 1)  # 고슴도치는 홍수보다 한 타임 늦다 따라서, time + 1 이므로 초기값 1
flood_s = []

for row in range(r):
    forest_map.append(list(sys.stdin.readline().strip()))
    for col in range(len(forest_map[row])):
        if forest_map[row][col] == 'D':
            D = (col, row)
        elif forest_map[row][col] == 'S':
            S = (col, row, 1)
        elif forest_map[row][col] == '*':
            flood_s.append((col, row, 1))

bfs_flood(flood_s)
result = bfs_dochi(S)


print(result)

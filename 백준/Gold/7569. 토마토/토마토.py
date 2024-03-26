import sys
from collections import deque


def check():
    for box in boxes:
        for line in box:
            for cell in line:
                if cell == 0:
                    return False
    return True


def in_range(x, y, z):
    return 0 <= x < m and 0 <= y < n and 0 <= z < h


# left down right up boxdown boxup
dx = (-1, 0, 1, 0, 0, 0)
dy = (0, -1, 0, 1, 0, 0)
dz = (0, 0, 0, 0, -1, 1)

total_day = 0


def bfs(starts: list):
    queue = deque()
    for start in starts:
        queue.append(start)
    global total_day

    while queue:
        x, y, z, day = queue.popleft()
        total_day = day
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]

            if in_range(nx, ny, nz) and boxes[nz][ny][nx] == 0:
                queue.append((nx, ny, nz, day + 1))
                boxes[nz][ny][nx] = 1


m, n, h = map(int, sys.stdin.readline().split())
boxes = [[] for _ in range(h)]
starts = []
for z in range(h):
    for y in range(n):
        boxes[z].append(list(map(int, sys.stdin.readline().split())))
        for x in range(m):
            if boxes[z][y][x] == 1:
                starts.append((x, y, z, 0))  # x, y, z, day = 0일차
bfs(starts)

if check():
    print(total_day)
else:
    print(-1)


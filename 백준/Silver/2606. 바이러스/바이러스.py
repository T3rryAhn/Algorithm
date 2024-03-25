import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
l = int(input())

nodes = [[] for _ in range(n + 1)]
for _ in range(l):
    a, b = map(int, input().split())
    nodes[a].append(b)
    nodes[b].append(a)
[node.sort() for node in nodes]
visited = [False] * (n + 1)


def bfs(start):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in nodes[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
bfs(1)
count = 0
for i in visited:
    if i:
        count += 1

print(count - 1)
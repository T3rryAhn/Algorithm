import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
nodes_in_count = [0 for _ in range(n + 1)]
nodes_out = [[] for _ in range(n + 1)]

queue = deque()

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    nodes_in_count[b] += 1
    nodes_out[a].append(b)


def topology_sort():
    result = []
    que = deque()

    for i in range(1, n + 1):
        if nodes_in_count[i] == 0:
            que.append(i)

    while que:
        now = que.popleft()
        result.append(now)

        for j in nodes_out[now]:
            nodes_in_count[j] -= 1
            if nodes_in_count[j] == 0:
                que.append(j)
    return result


print(*topology_sort())


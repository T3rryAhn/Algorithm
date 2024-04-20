import sys
from sys import stdin
sys.setrecursionlimit(10**6)

n, m, r = map(int, stdin.readline().split())

nodes = [[] for _ in range(n + 1)]
result = [0 for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    start, end = map(int, stdin.readline().split())

    nodes[start].append(end)
    nodes[end].append(start)

order = 1


def dfs(nodes, nextNodes, start):
    global order
    visited[start] = True
    nextNodes.sort(reverse=True)
    result[start] = order
    order += 1
    for i in nextNodes:
        if not visited[i]:
            dfs(nodes, nodes[i], i)


dfs(nodes, nodes[r], r)

for i in range(1, n + 1):
    print(result[i])

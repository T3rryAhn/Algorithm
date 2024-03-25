import sys
from collections import deque

n = int(sys.stdin.readline())
nodes = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
parent_table = [i for i in range(n + 1)]

for _ in range(n - 1):
    node_a, node_b = map(int, sys.stdin.readline().split())
    nodes[node_a].append(node_b)
    nodes[node_b].append(node_a)


def bfs(root: int) -> None:
    queue = deque()
    queue.append(root)

    while queue:
        node = int(queue.popleft())
        visited[node] = True
        for n_node in nodes[node]:
            if not visited[n_node]:
                parent_table[n_node] = node
                queue.append(n_node)


bfs(1)
for i in range(2, n + 1):
    print(parent_table[i])
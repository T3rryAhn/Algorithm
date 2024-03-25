import sys
import heapq
from collections import deque

n, m, start = map(int, sys.stdin.readline().split())
nodes = [[] for _ in range(n + 1)]
for _ in range(m):
    node_start, node_end = map(int, sys.stdin.readline().split())
    nodes[node_start].append(node_end)
    nodes[node_end].append(node_start)
[node.sort() for node in nodes]

def dfs(start_node):
    def _dfs(start_node):
        result.append(start_node)
        visit.add(start_node)
        for n in nodes[start_node]:
            if n not in visit:
                _dfs(n)

    visit = set()
    result = []
    _dfs(start_node)
    return result


def bfs(start_node):
    result = []
    is_visited = [False] * (n + 1)
    que = deque()
    que.append(start_node)
    is_visited[start_node] = True
    result.append(start_node)

    while que:
        node = int(que.popleft())
        for i in nodes[node]:
            if not is_visited[i]:
                que.append(i)
                is_visited[i] = True
                result.append(i)

    return result


print(*dfs(start))
print(*bfs(start))

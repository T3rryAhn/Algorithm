import sys
import heapq

n, m = map(int, sys.stdin.readline().split())
nodes = [[] for _ in range(n + 1)]
node_in_count = [0 for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    nodes[a].append(b)
    node_in_count[b] += 1

result = []
queue = []
for i in range(1, n + 1):
    if node_in_count[i] == 0:
        heapq.heappush(queue, i)

while queue:
    next = heapq.heappop(queue)
    result.append(next)
    for node in nodes[next]:
        node_in_count[node] -= 1
        if node_in_count[node] == 0:
            heapq.heappush(queue, node)

print(*result)
import sys
import heapq

INF = sys.maxsize


V, E = map(int, sys.stdin.readline().split())
k = int(sys.stdin.readline())
cost = [INF for _ in range(V + 1)]
line = [[] for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    line[u].append((w, v))


queue = [(0, k)]
cost[k] = 0
while queue:
    c, now = heapq.heappop(queue)

    for next in line[now]:
        nw, nv = next
        if cost[nv] > c + nw:
            cost[nv] = c + nw
            heapq.heappush(queue, (c + nw, nv))

for i in range(1, V + 1):
    if i == k:
        print(0)
    elif cost[i] == INF:
        print('INF')
    else:
        print(cost[i])






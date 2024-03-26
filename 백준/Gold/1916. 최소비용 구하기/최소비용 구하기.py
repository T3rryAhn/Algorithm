import sys
import heapq

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

cities = [[] for _ in range(n + 1)]
INF = sys.maxsize
cost = [INF] * (n + 1)

for _ in range(m):
    s, e, c = map(int, sys.stdin.readline().split())
    cities[s].append([e, c])
start, end = map(int, sys.stdin.readline().split())
def dijkstra(start):
    heap = []
    heapq.heappush(heap, (0, start))
    cost[start] = 0

    while heap:
        c, v = heapq.heappop(heap)
        if cost[v] < c:
            continue
        for n_city, n_cost in cities[v]:
            new_cost = c + n_cost
            if cost[n_city] > new_cost:
                cost[n_city] = new_cost
                heapq.heappush(heap, (new_cost, n_city))

dijkstra(start)

print(cost[end])



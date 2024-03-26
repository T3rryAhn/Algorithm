import sys
from collections import deque


def bfs(start):
    queue = deque()
    queue.append(start)
    visited_cost[start] = 0

    while queue:
        v_city = queue.popleft()
        for n_city in cities[v_city]:
            if visited_cost[n_city] > visited_cost[v_city] + 1:
                queue.append(n_city)
                visited_cost[n_city] = visited_cost[v_city] + 1


n, m, k, x = map(int, sys.stdin.readline().split())
cities = [[] for _ in range(n + 1)]
INF = sys.maxsize
visited_cost = [INF] * (n + 1)
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    cities[a].append(b)

bfs(x)
result = []
for i in range(1, n + 1):
    if visited_cost[i] == k:
        result.append(i)

if result:
    for i in result:
        print(i)
else:
    print(-1)


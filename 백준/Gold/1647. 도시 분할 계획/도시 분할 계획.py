import sys
import heapq

n, m = map(int, sys.stdin.readline().split())

way = []
parent_table = list(range(n + 1))
result = 0
tmp = []

def find_parent(child: int) -> int:
    if child == parent_table[child]:
        return child
    parent = parent_table[child]
    return find_parent(parent)


for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    heapq.heappush(way, (c, a, b))

while way:
    cost, s, e = heapq.heappop(way)

    if find_parent(s) != find_parent(e):
        if find_parent(s) > find_parent(e):
            parent_table[find_parent(s)] = find_parent(e)
        else:
            parent_table[find_parent(e)] = find_parent(s)

        result += cost
        tmp.append(cost)

print(result - max(tmp))
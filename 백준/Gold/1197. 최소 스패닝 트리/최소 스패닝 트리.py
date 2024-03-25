import sys
import heapq


def find_parent(node, parent):
    if node != parent:
        parent = find_parent(parent, parents[parent])
    return parent



input = sys.stdin.readline
v, e = map(int, input().split())
ways = []
for _ in range(e):
    start, end, cost = map(int, input().split())
    heapq.heappush(ways, (cost, start, end))

parents = [i for i in range(v + 1)]  # 편의를 위해 0 노드 삽입
total_cost = 0

while ways:
    cost, start, end = heapq.heappop(ways)
    start_parent = find_parent(start, parents[start])
    end_parent = find_parent(end, parents[end])
    if start_parent != end_parent:
        if start_parent > end_parent:
            parents[start_parent] = end_parent
        else:
            parents[end_parent] = start_parent
        total_cost += cost

print(total_cost)


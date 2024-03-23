import sys
import heapq
input = sys.stdin.readline

n = int(input())
person = []

for _ in range(n):
    start, end = map(int, input().split())
    if start > end:
        start, end = end, start
    heapq.heappush(person, (end, start))

d = int(input())

possible = []
count = 0
result = 0
while person:
    end, start = heapq.heappop(person)
    if start >= end - d:
        heapq.heappush(possible, (start, end))
        count += 1
    while possible:
        s, e = heapq.heappop(possible)
        if s < end - d:
            count -= 1
        else:
            heapq.heappush(possible, (s, e))
            break

    result = max(result, count)

print(result)
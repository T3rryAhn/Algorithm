import sys

import heapq


x = []
n = int(sys.stdin.readline())
for _ in range(n):
    num = int(sys.stdin.readline())
    if num > 0:
        heapq.heappush(x, (-num))
    else:
        if x:
            print(-heapq.heappop(x))
        else:
            print(0)

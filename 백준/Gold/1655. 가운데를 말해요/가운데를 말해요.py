import heapq

import sys

max_heap=[]
min_heap=[]
n = int(sys.stdin.readline())


for i in range(n):
    if i % 2 == 0:
        heapq.heappush(max_heap, (-int(sys.stdin.readline())))
    else:
        heapq.heappush(min_heap, (int(sys.stdin.readline())))


    if min_heap and -max_heap[0] > min_heap[0]:
        temp1 = -heapq.heappop(max_heap)
        temp2 = heapq.heappop(min_heap)

        heapq.heappush(max_heap, -temp2)
        heapq.heappush(min_heap, temp1)

    print(-max_heap[0])



7
5
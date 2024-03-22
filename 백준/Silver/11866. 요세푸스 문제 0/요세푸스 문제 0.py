import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
result = []

dq = deque(list(range(1, n + 1)))

for _ in range(n):
    for _ in range(k - 1):
        dq.append(dq.popleft())
    result.append(dq.popleft())

result_str = str(result)
print(f'<{result_str[1:-1]}>')
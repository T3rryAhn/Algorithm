import sys

n = int(sys.stdin.readline())
result = []
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())

    if a <= b:
        result.append(b)

if result:
    print(min(result))
else:
    print(-1)


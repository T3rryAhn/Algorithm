from sys import stdin


N, L = map(int, stdin.readline().split())
holePoint = list(map(int, stdin.readline().split()))
holePoint.sort()
holes = []

if N == 1:
    print(1)
    exit(0)

count = 1
start = 0
for i in range(1, N):
    if (holePoint[i] - holePoint[start] + 1) > L:
        count += 1
        start = i

print(count)
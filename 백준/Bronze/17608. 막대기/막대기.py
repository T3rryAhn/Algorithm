import sys

n = int(sys.stdin.readline())
lst = [int(sys.stdin.readline()) for _ in range(n)]
count = 1
temp = lst[-1]
for i in range(n - 1, -1, -1):
    if lst[i] > temp:
        count += 1
        temp = lst[i]

print(count)

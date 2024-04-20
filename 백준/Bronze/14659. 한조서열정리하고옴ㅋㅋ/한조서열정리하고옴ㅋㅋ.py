from sys import stdin

n = int(stdin.readline())
tower = list(map(int, stdin.readline().split()))
max_count = 0

i = 0
while i < len(tower):
    count = 0
    j = i + 1
    h = tower[i]
    while j < len(tower) and h >= tower[j]:
        count += 1
        j += 1
    max_count = max(max_count, count)
    i = j

print(max_count)

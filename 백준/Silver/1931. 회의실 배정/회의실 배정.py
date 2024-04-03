import sys

n = int(sys.stdin.readline())

meetings = []
for _ in range(n):
    s, e = map(int, sys.stdin.readline().split())
    meetings.append((e, s))
meetings.sort()

count = 0
last_end_time = 0
for end, start in meetings:
    if start >= last_end_time:
        count += 1
        last_end_time = end
print(count)

import sys

count_num = [0] * 10_000

n = int(sys.stdin.readline())

for _ in range(n):
    num = int(sys.stdin.readline())
    count_num[num - 1] += 1

index = 0
for i in count_num:
    index += 1
    for _ in range(i):
        print(index)

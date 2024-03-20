import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
targets = list(map(int, sys.stdin.readline().split()))
a.sort()


def find(target):
    pl = 0
    pr = len(a) - 1
    result = 0
    while pl <= pr:
        pc = (pl + pr) // 2
        if a[pc] == target:
            result = 1
        if a[pc] > target:
            pr = pc - 1
        else:
            pl = pc + 1

    return result


for target in targets:
    print(find(target))

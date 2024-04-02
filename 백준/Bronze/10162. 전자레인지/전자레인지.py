import sys

t = int(sys.stdin.readline())

btns = [0, 0, 0]

btns[0] = t // 300
t %= 300
btns[1] = t // 60
t %= 60
btns[2] = t // 10

if t % 10:
    print(-1)
else:
    print(*btns)
from sys import stdin

T = int(stdin.readline())
cases = [list(map(int, stdin.readline().split())) for _ in range(T)]

for case in cases:
    case.sort()
    case[0], case[-1] = 0, 0
    if case[-2] - case[1] >= 4:
        print("KIN")
        continue
    print(sum(case))
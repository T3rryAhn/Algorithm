w, h = map(int, input().split())
n = int(input())
x = [0, w]
y = [0, h]

for _ in range(n):
    cut_axis, cut_line = map(int, input().split())
    if cut_axis == 0:
        y.append(cut_line)
    else:
        x.append(cut_line)


x.sort()
y.sort()


def cut_axis(axis: list):
    cutted = []
    for i in range(len(axis) - 1):
        cutted.append(axis[i + 1] - axis[i])
    return max(cutted)


print(cut_axis(x) * cut_axis(y))
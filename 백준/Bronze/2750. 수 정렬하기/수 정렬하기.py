import sys


def bubble_sort(lst: list) -> None:
    for _ in lst:
        for i in range(len(lst) - 1):
            if lst[i] > lst[i + 1]:
                lst[i], lst[i + 1] = lst[i + 1], lst[i]


n = int(sys.stdin.readline())
num_lst = []
for _ in range(n):
    num_lst.append(int(sys.stdin.readline()))

bubble_sort(num_lst)

for i in num_lst:
    print(i)
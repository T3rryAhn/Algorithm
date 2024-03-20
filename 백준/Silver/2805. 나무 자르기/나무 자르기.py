import sys

n, m = map(int, sys.stdin.readline().split())

trees = list(map(int, sys.stdin.readline().split()))


def cut(trees, m):
    left = 0
    right = max(trees)
    result = 0

    while left <= right:
        mid = (left + right) // 2
        sum = 0

        for tree in trees:
            cutted_tree = tree - mid
            if cutted_tree > 0:
                sum += cutted_tree

        if sum < m:
            right = mid - 1
        else:
            left = mid + 1
            result = left

    return result - 1


print(cut(trees, m))

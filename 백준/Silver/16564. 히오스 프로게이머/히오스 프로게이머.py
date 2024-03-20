import sys

n, k = map(int, sys.stdin.readline().split())
x = list(int(sys.stdin.readline()) for _ in range(n))

x.sort()


def heos():
    left = min(x)
    right = left + k
    result = 0
    while left <= right:
        mid = (left + right) // 2

        sum = 0
        # target
        for i in x:
            if mid - i > 0:
                sum += mid - i

        if sum > k:
            right = mid - 1
        else:
            result = mid
            left = mid + 1

    return result

print(heos())


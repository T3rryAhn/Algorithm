import sys

n, m = map(int, sys.stdin.readline().split())

arr = [int(sys.stdin.readline()) for _ in range(n)]
arr.sort()

for _ in range(m):
    target = int(sys.stdin.readline())

    left = 0
    right = len(arr) - 1
    result = -1
    while left <= right:
        mid = left + (right - left) // 2
        if target == arr[mid]:
            result = mid
            right = mid - 1
        elif target > arr[mid]:
            left = mid + 1
        else:
            right = mid - 1
    print(result)
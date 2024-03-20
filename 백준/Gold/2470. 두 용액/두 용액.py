import sys

n = int(sys.stdin.readline())
liquids = list(map(int, sys.stdin.readline().split()))
liquids.sort()


def find():
    left = 0
    right = n - 1
    ans = abs(liquids[left] + liquids[right])

    result = [liquids[left], liquids[right]]
    while left < right:
        sum = liquids[left] + liquids[right]
        temp = abs(sum)

        if temp < ans:
            ans = temp
            result = [liquids[left], liquids[right]]
            if ans == 0:
                break
        if sum < 0:
            left += 1
        else:
            right -= 1

    return result


a = find()
print(f'{a[0]} {a[1]}')

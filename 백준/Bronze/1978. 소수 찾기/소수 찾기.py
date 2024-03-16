def isDecimal(target_num: int) -> bool:
    if target_num == 1: return False

    for i in range(2, target_num):
        if target_num % i == 0:
            return False
    return True


n = int(input())
numbers = list(map(int, input().split()))

count = 0

for i in numbers:
    if isDecimal(i):
        count += 1

print(count)
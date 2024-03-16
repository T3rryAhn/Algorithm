import math


def is_primary(num: int) -> bool:
    if num <= 1:
        return False
    if num == 2:
        return True

    check_range = range(2, int(math.sqrt(num)) + 1)

    for i in check_range:
        if num % i == 0:
            return False
    return True


def show_partition(target: int):
    num = target
    check_start_num = num // 2

    for i in range(check_start_num, 1, -1):
        if is_primary(i) and is_primary(num - i):
            print(f'{i} {num - i}')
            break


t = int(input())
for _ in range(t):
    show_partition(int(input()))
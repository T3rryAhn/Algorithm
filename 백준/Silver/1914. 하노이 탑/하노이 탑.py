"""
f(1) = 1
f(2) = 3
f(3) = 7
f(n + 1) = 2f(n) + 1
"""


def count_hanoi(n):
    if n == 1:
        return 1

    return 2 * count_hanoi(n - 1) + 1


def move_hanoi(n: int, start_pillar: int, end_pillar: int, temp_pillar):
    if n == 0:
        return

    move_hanoi(n - 1, start_pillar, temp_pillar, end_pillar)

    print(f'{start_pillar} {end_pillar}')

    move_hanoi(n - 1, temp_pillar, end_pillar, start_pillar)


n = int(input())

print(count_hanoi(n))

if n <= 20:
    move_hanoi(n, 1, 3, 2)
import sys

n = int(sys.stdin.readline())


def sum_to_n(n: int) -> int:
    if n == 1:
        return 1
    return n + sum_to_n(n - 1)


def power(n: int) -> int:
    if n == 1:
        return 1
    return n**3 + power(n - 1)


a = sum_to_n(n)
b = a ** 2
c = power(n)
print(f'{a}\n{b}\n{c}')

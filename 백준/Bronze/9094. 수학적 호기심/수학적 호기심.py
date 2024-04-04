import sys


def counter(n: int, m: int) -> int:
    count = 0
    for a in range(1, n):
        for b in range(a + 1, n):
            if ((a ** 2) + (b ** 2) + m) % (a * b) == 0:
                count += 1

    return count


t = int(sys.stdin.readline())

for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    print(counter(n, m))
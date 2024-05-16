from sys import stdin

A, K = map(int, stdin.readline().split())

count = 0

while K != A:
    if K & 1:
        K -= 1
        count += 1
    else:
        if K // 2 >= A:
            K //= 2
            count += 1
        else:
            K -= 1
            count += 1

print(count)
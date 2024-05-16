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

# K 에서 거꾸로 A로 연산해 나가는 방법으로 한다면 bfs, dfs, dp 필요없음
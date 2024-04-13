from sys import stdin

def sort_chicken(tastes, start, end):
    temp = tastes[start:end]
    temp.sort()
    j = 0
    for i in range(start, end):
        tastes[i] = temp[j]
        j += 1

n = int(stdin.readline())
tastes = list(map(int, stdin.readline().split()))
k = int(stdin.readline())

chunk_size = n // k  # 각 회원이 선택할 치킨집의 범위 크기

for i in range(0, n, chunk_size):
    sort_chicken(tastes, i, min(i + chunk_size, n))

print(*tastes)

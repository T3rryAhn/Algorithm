n, k= map(int, input().split())
t = [0] + [1e5] * k
c = []
for _ in range(n):
    c.append(int(input()))
c.sort()
for i in c:
    for j in range(i, k + 1):
        t[j] = min(t[j], t[j - i] + 1)

print([-1, t[k]][t[k] < 1e5])
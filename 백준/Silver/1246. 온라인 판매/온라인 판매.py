from sys import stdin

N, M = map(int, stdin.readline().split())
P = [int(stdin.readline()) for _ in range(M)]
P.sort(reverse=True)

numberOfCheck = min(N, M)
maxRevenue = 0
price = 0
for i in range(numberOfCheck):
    revenue = P[i] * (i + 1)
    maxRevenue = max(maxRevenue, revenue)
    if maxRevenue == revenue:
        price = P[i]

print(f"{price} {maxRevenue}")
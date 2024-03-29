import sys

t = int(sys.stdin.readline())   # 목표 금액
k = int(sys.stdin.readline())   # 동전 종류 수

coins = []                      # 동전 값, 수량
for i in range(k):
    p, n = map(int, sys.stdin.readline().split())
    coins.append((p, n))


# dp 배열 초기화. 금액 0을 만드는 경우의 수는 1.[[0원 동전 dp], [p1원 동전 dp], [p2원 동전 dp], ... , [pk원 동전 dp]]
dp = [[0] * (t + 1) for _ in range(k + 1)]
dp[0][0] = 1

for i in range(1, k + 1):       # 동전 종류 수 만큼 반복
    coin_value, coin_count = coins[i - 1]
    for j in range(t + 1):      # 0원 부터 ~ t 원 까지 반복
        dp[i][j] = dp[i - 1][j]     # 현재 고른 동전을 사용하지 않는 경우의 수
        for l in range(1, coin_count + 1):  # 동전을 한개씩 꺼내보면서 쓸수있는 만큼 반복
            if j >= coin_value * l:
                dp[i][j] += dp[i - 1][j - coin_value * l]

print(dp[k][t])
N, M = map(int, input().split())
dp = [0 for _ in range(M + 1)]

for _ in range(N):
    w, v, k = map(int, input().split())
    i = 1
    while k > 0:
        num = min(k, i)
        k -= num
        i *= 2
        total_w = w * num
        total_v = v * num
        # DP 배열을 업데이트하는 과정
        for j in range(M, total_w - 1, -1):
            dp[j] = max(dp[j], dp[j - total_w] + total_v)

print(dp[M])

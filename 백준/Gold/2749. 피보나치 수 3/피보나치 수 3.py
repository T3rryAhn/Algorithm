# 피사노 주기를 활용해 푸는 문제
# 피보나치 수를 일정한 수 k 로 나누면 같은 숫자가 반복됨.


n = int(input()) % (15 * 10 ** 5)
dp = [0] * (n + 1)
dp[0] = 0
dp[1] = 1
for i in range(2, n + 1):
    dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000
print(dp[n])

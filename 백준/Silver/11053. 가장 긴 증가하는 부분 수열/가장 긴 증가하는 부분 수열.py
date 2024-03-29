n = int(input())  # sys.stdin.readline() 대신 input() 사용
arr = list(map(int, input().split()))  # 테스트를 위해 입력 방법을 변경
dp = [1 for _ in range(n)]

for i in range(1, n):
    for j in range(i):
        if arr[j] < arr[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))

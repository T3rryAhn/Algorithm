n = int(input())

memo = ['' for _ in range(1001)]
memo[1] = 'SK'
memo[2] = 'CY'
memo[3] = 'SK'
memo[4] = 'CY'

for i in range(5, n + 1):
    if memo[i - 3] != memo[i - 1]:
        memo[i] = memo[i - 3]
    else:
        memo[i] = memo[i - 2]

print(memo[n])

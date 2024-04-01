import sys

target_string = sys.stdin.readline().strip()
n = int(sys.stdin.readline())
words = [sys.stdin.readline().strip() for _ in range(n)]


def can_form_string(target_string, words):
    n = len(target_string)
    dp = [False] * (n + 1)
    dp[0] = True  # 초기 조건 설정

    for i in range(n):
        if not dp[i]:
            continue
        for word in words:
            if target_string[i:i + len(word)] == word:
                dp[i + len(word)] = True

    return dp[n]


result = can_form_string(target_string, words)
print(1 if result else 0)

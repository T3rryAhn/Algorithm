import sys

t = int(sys.stdin.readline())

coins = [0] * 4
for _ in range(t):
    amount = int(sys.stdin.readline())

    coins[0] = amount // 25
    amount %= 25
    coins[1] = amount // 10
    amount %= 10
    coins[2] = amount // 5
    amount %= 5
    coins[3] = amount

    print(*coins)
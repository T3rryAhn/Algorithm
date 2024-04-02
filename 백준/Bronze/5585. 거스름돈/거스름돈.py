amount = int(input())

result = [0] * 6
coins = (500, 100, 50, 10, 5, 1)
amount = 1000 - amount
for index, coin in enumerate(coins):
    result[index] = amount // coin
    amount %= coin

print(sum(result))

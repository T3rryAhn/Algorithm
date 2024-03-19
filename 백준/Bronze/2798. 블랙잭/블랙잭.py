import sys


def combination(r: int, numbers: list) -> list:
    result = []
    if r == 0:
        return [[]]

    for i in range(len(numbers)):
        chosen = numbers[i]
        remain = numbers[i + 1:]

        for combo in combination(r - 1, remain):
            result.append([chosen] + combo)

    return result


n, m = map(int, sys.stdin.readline().split())
numbers = list(map(int, sys.stdin.readline().split()))

result = combination(3, numbers)
max_sum = 0

for combi in result:
    if sum(combi) > m:
        continue
    if max_sum < sum(combi):
        max_sum = sum(combi)
print(max_sum)

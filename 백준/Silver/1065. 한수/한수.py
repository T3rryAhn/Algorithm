def is_hansu(num: str):
    if int(num) < 10:
        return True

    r = int(num[0]) - int(num[1])

    for i in range(len(num) - 1):
        if r != int(num[i]) - int(num[i + 1]):
            return False
    return True


n = input()
count = 0

for i in range(1, int(n) + 1):
    if is_hansu(str(i)):
        count += 1

print(count)

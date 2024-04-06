import sys

n, k = map(int, sys.stdin.readline().split())


# a = ''
# for i in range(1, n + 1):
#     a += str(i)
#
# print(a[k - 1])

# 자릿수 판별기
def check_digit(num: int) -> tuple:
    digit = 1
    while digit * (10 ** (digit - 1)) * 9 < num:
        num -= digit * (10 ** (digit - 1)) * 9
        digit += 1

    return digit, num


digit, num = check_digit(k)
number = 10 ** (digit - 1) + (num - 1) // digit
digit_index = (num - 1) % digit
if number > n:
    print(-1)
else:
    print(str(number)[digit_index])



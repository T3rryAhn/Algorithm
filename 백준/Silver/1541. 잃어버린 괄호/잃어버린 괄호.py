import sys

user_input = sys.stdin.readline().strip() + '+'
result = 0
minus = 0

is_minus = False
temp_num = ''
num = 0
for c in user_input:
    # print(f'c:{c}')
    if c != '-' and c != '+':
        temp_num += c
    else:
        num = int(temp_num)
        temp_num = ''

        if is_minus:
            result -= num
        else:
            result += num

        if c == '-':
            is_minus = True

    # print(f'num:{num}')
    # print(f'result:{result}')
    # print()

print(result)

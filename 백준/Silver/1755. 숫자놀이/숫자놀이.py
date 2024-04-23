M, N = map(int, input().split())

# arr = [[charsum, string]]
arr = []


def transfer_digit_to_alphabet(digit: chr) -> chr:
    if digit == '1':
        return 'one'
    elif digit == '2':
        return 'two'
    elif digit == '3':
        return 'three'
    elif digit == '4':
        return 'four'
    elif digit == '5':
        return 'five'
    elif digit == '6':
        return 'six'
    elif digit == '7':
        return 'seven'
    elif digit == '8':
        return 'eight'
    elif digit == '9':
        return 'nine'
    else:
        return 'zero'


for num in range(M, N + 1):
    string_num = str(num)
    word_num = ''
    for digit in string_num:
        word_num += transfer_digit_to_alphabet(digit)
    arr.append([word_num, num])

arr.sort()

i = 0
for word, num in arr:
    if i == 10:
        print()
        i = 0
    i += 1
    print(f"{num}", end=' ')


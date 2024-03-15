n, x = map(int, input().split())
num_list = map(int, input().split())

result = ''

for i in num_list:
    if i < x:
        result += str(i) + ' '

print(result)

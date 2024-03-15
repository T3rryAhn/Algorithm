a = int(input())
b = int(input())
c = int(input())

multi = a * b * c

list = [0] * 10

for c in str(multi):
    list[int(c)] += 1

for i in list:
    print(i)
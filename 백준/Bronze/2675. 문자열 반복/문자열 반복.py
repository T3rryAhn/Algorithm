t = int(input())

for _ in range(t):
    r, s = input().split()
    result = ''
    for c in s:
        for _ in range(int(r)):
            result += c

    print(result)
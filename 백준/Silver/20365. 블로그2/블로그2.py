from sys import stdin

n = stdin.readline()
problems = stdin.readline().strip()

R, B = 0, 0

tempChar = ''
for c in problems:
    if tempChar == c:
        continue
    else:
        if c == 'R':
            R += 1
        else:
            B += 1
    tempChar = c

print(min(R, B) + 1)
x, y, w, h = input().split()

x = int(x)
y = int(y)
w = int(w)
h = int(h)

disX = min(x, w - x)
disY = min(y, h - y)
result = disY

if disX < disY:
    result = disX

print(result)


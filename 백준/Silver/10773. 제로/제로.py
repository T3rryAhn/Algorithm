import sys

stack = []

k = int(sys.stdin.readline())
for _ in range(k):
    user_input = int(sys.stdin.readline())
    if user_input == 0:
        if stack:
            stack.pop()
    else:
        stack.append(user_input)

total = sum(stack)
print(total)

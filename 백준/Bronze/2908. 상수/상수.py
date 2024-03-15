a, b = input().split()


def reverse(s: str):
    result = ''
    for i in range(len(s) - 1, -1, -1):
        result += s[i]
    return result


print(max(int(reverse(a)), int(reverse(b))))

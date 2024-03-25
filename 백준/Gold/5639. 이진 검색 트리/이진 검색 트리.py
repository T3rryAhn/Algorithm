# 50     30 24 5 28   45   98 52 60
import sys
sys.setrecursionlimit(10**9)


def solve(arr: list):
    answer = []

    def _solve(start, end):
        if start >= end : return
        root = arr[start]
        i = start + 1
        while i < end and arr[i] < root: i += 1
        _solve(start + 1, i)
        _solve(i, end)
        answer.append(root)
    _solve(0,len(arr))
    return answer

user_input =[]

while True:
    try:
        user_input.append(int(sys.stdin.readline()))
    except:
        break
print(*solve(user_input),sep='\n')



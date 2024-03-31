import sys
sys.setrecursionlimit(10**8)

string1 = sys.stdin.readline().strip()
string2 = sys.stdin.readline().strip()

x = len(string1)
y = len(string2)

memo = [[0 for _ in range(x + 1)] for _ in range(y + 1)]


def lcs(i, j):  # i string1 인덱스 j string2 인덱스 지만 - 1 을 해야하는 것에 주의!!!!
    if string1[i - 1] == string2[j - 1]:
        memo[j][i] = memo[j - 1][i - 1] + 1
    else:
        memo[j][i] = max(memo[j - 1][i], memo[j][i - 1])


def find_lcs(x, y):
    result = []

    def _find_lcs(x, y):
        if memo[y][x] == 0:
            return

        if string1[x - 1] == string2[y - 1]:
            result.append(string1[x - 1])
            _find_lcs(x - 1, y - 1)
        elif memo[y][x - 1] > memo[y - 1][x]:
            _find_lcs(x - 1, y)
        else:
            _find_lcs(x, y - 1)

    _find_lcs(x, y)

    return result[::-1]


for j in range(1, y + 1):
    for i in range(1, x + 1):
        lcs(i, j)
#
# print(memo[-1][-1])
# for m in memo:
#     print(m)
print(memo[-1][-1])
print(''.join(find_lcs(x, y)))


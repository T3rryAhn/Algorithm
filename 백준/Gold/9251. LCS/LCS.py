import sys

string1 = sys.stdin.readline().strip()
string2 = sys.stdin.readline().strip()

memo = [[0 for _ in range(len(string1) + 1)] for _ in range(len(string2) + 1)]


def lcs_bottom_up(i, j):
    if string1[i - 1] == string2[j - 1]:
        memo[j][i] = memo[j - 1][i - 1] + 1
    else:
        memo[j][i] = max(memo[j][i - 1], memo[j - 1][i])


for y in range(1, len(string2) + 1):
    for x in range(1, len(string1) + 1):
        lcs_bottom_up(x, y)

# for m in memo:
#     print(m)

print(memo[-1][-1])
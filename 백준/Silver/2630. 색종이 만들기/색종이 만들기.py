import sys

n = int(sys.stdin.readline())
paper = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

white_count = 0
blue_count = 0


def check_all_colored(s_row, e_row, s_col, e_col) -> bool:
    global white_count, blue_count
    sum = 0
    multi = 1
    for row in range(s_row, e_row):
        for col in range(s_col, e_col):
            sum += paper[row][col]
            multi *= paper[row][col]
    if sum == 0:
        white_count += 1
        return True
    if multi == 1:
        blue_count += 1
        return True
    return False


def divide_to_four(s_row, e_row, s_col, e_col):
    global white_count, blue_count
    if check_all_colored(s_row, e_row, s_col, e_col):
        return

    pivot_row = (s_row + e_row) // 2
    pivot_col = (s_col + e_col) // 2

    divide_to_four(s_row, pivot_row, s_col, pivot_col)
    divide_to_four(s_row, pivot_row, pivot_col, e_col)
    divide_to_four(pivot_row, e_row, s_col, pivot_col)
    divide_to_four(pivot_row, e_row, pivot_col, e_col)


divide_to_four(0, n, 0, n)
print(f'{white_count}\n{blue_count}')

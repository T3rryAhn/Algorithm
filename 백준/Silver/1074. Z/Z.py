def where(n, x, y) -> int:  # 0, 1, 2, 3 분면
    boundary = 2 ** (n - 1)

    if x < boundary:
        if y < boundary:
            return 0
        return 2
    else:
        if y < boundary:
            return 1
        return 3


def transform_coordinate(n, quadrant, x, y):  # 2^n 크기의 좌표를 2^(n - 1) 로 변환
    distance = 2 ** (n - 1)

    if quadrant == 0:
        return x, y
    if quadrant == 1:
        return x - distance, y
    if quadrant == 2:
        return x, y - distance
    if quadrant == 3:
        return x - distance, y - distance


def visit_order(n, x, y):
    if n == 1:
        return where(n, x, y)

    quadrant = where(n, x, y)
    order = (2 ** (2 * (n - 1))) * quadrant
    x, y = transform_coordinate(n, quadrant, x, y)
    order += visit_order(n - 1, x, y)
    return order


# 입력부
n, row, col = map(int,input().split())
# 주의 row = y, col = x !!!!!

result = visit_order(n, col, row)
print(result)

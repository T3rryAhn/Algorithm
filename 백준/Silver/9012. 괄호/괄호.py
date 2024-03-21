import sys


def check_vps(lst: list) -> None:
    right_open = []

    for i in lst:
        if i == '(':
            right_open.append(1)
        else:
            if right_open:
                right_open.pop()
            else:
                print('NO')
                return
    if right_open:
        print('NO')
        return
    print('YES')


if __name__ == "__main__":
    t = int(sys.stdin.readline())

    for _ in range(t):
        user_input = sys.stdin.readline().strip()
        check_vps(list(user_input))

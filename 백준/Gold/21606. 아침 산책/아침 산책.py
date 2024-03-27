import sys


def check_indoor(node) -> bool:
    if place[node] == 1:
        return True
    else:
        return False


def walk():
    visited = [False for _ in range(n + 1)]
    count = 0

    def walk_one(arrived):
        nonlocal count, visited
        visited[arrived] = True
        if check_indoor(arrived):
            count += 1
            return

        for next in line[arrived]:
            if not visited[next]:
                walk_one(next)

    for start in range(1, n + 1):
        if check_indoor(start):
            visited = [False for _ in range(n + 1)]
            visited[start] = True
            for next in line[start]:
                walk_one(next)
    return count


if __name__ == '__main__':
    n = int(sys.stdin.readline())
    info = sys.stdin.readline().strip()

    place = {i + 1: int(j) for i, j in enumerate(info)}
    line = [[] for _ in range(n + 1)]

    for _ in range(1, n):
        s, e = map(int, sys.stdin.readline().split())
        line[s].append(e)
        line[e].append(s)

    print(walk())

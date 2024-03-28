import sys
sys.setrecursionlimit(10**8)

n = int(sys.stdin.readline())
node = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, sys.stdin.readline().split())
    node[a].append(b)
    node[b].append(a)

parent_table = [i for i in range(n + 1)]
visited = [False for _ in range(n + 1)]

def dps(n):
    for next in node[n]:
        if not visited[next]:
            visited[next] = True
            parent_table[next] = n
            dps(next)

dps(1)

for i in parent_table[2:]:
    print(i)

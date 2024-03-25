import sys
from collections import deque


def bfs(root: int, nodes: list, group: list) -> bool:
    queue = deque()
    queue.append((root))
    group[root] = 1

    while queue:
        current = queue.popleft()

        for n_node in nodes[current]:
            if not group[n_node]:
                group[n_node] = -group[current]
                queue.append(n_node)
            else:
                if group[n_node] == group[current]:
                    # print('NO')
                    return False

    # print('YES')
    return True


k = int(sys.stdin.readline())
for _ in range(k):
    v, e = map(int, sys.stdin.readline().split())
    nodes = [[] for _ in range(v + 1)]
    group = [0 for _ in range(v + 1)]
    for _ in range(e):
        node_a, node_b = map(int, sys.stdin.readline().split())
        nodes[node_a].append(node_b)
        nodes[node_b].append(node_a)

    # 모든 미방문 노드에 대해 BFS를 시작하여 그래프 전체를 확인
    is_bipartite = True
    for i in range(1, v + 1):
        if group[i] == 0:  # 노드 i가 방문되지 않은 경우
            if not bfs(i, nodes, group):
                is_bipartite = False
                break

    print("YES" if is_bipartite else "NO")

import sys

sys.setrecursionlimit(5000)

input = sys.stdin.readline


# dfs 그래프 탐색
def dfs(start, depth):
    # 해당 노드 방분 체크
    visited[start] = True

    # 해당 시작점을 기준으로 곔속해서 dfs로 그래프 탐색
    for i in graph[start]:
        if not visited[i]:
            dfs(i, depth + 1)


N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 방문처리
visited = [False] * (1 + N)
count = 0  # 컴포넌트 그래프 개수 저장

# 1~N번 노드를 각각 돌면서
for i in range(1, N + 1):
    if not visited[i]:              # 만약 i 번째 노드를 방문하지 않았다면
        if not graph[i]:            # 만약 해당 정점이 연결된그래프가 없다면
            count += 1
            visited[i] = True
        else:                       # 연결된 그래프가 있다면
            dfs(i, 0)           # dfs 탐색을 돈다.
            count += 1

print(count)
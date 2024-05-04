import sys
input = sys.stdin.readline

# r X c  맵
# 거리가 k 인 가짓수 구하기
r,c,k = map(int, input().split())
graph = []
for _ in range(r):
    graph.append(list(input().rstrip()))

dx = [1,-1,0,0]
dy = [0,0,1,-1]

answer = 0
def dfs(x,y,distance):
    global answer
    # 목표 도착 지점 : (0,c-1)
    # 목표 거리 : k
    if distance == k and y == c-1 and x==0:
        answer += 1
    else:
        # T로 방문처리
        graph[x][y]='T'
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            # 백트래킹 한정 조건 : graph[nx][ny] == '.'
            if(0 <= nx < r and 0 <= ny < c and graph[nx][ny] == '.'):
                graph[nx][ny]='T'
                dfs(nx,ny,distance+1)
                # 원래 상태로 돌려 놓아 다른 방향으로 다시 탐색하도록 한다.
                graph[nx][ny]='.'

# 시작점 : (r-1,0)
# 초기 distance : 1
dfs(r-1,0,1)
# 정답
print(answer)
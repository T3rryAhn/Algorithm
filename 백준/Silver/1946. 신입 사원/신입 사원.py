import sys


def newbie_cutter(people):
    # 서류 심사 순위를 기준으로 정렬
    people.sort()
    max_interview_rank = sys.maxsize
    count = 0

    for _, interview_rank in people:
        if interview_rank < max_interview_rank:
            count += 1
            max_interview_rank = interview_rank

    print(count)

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    people = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]
    newbie_cutter(people)
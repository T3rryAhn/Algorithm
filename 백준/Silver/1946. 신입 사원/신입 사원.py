import sys
from collections import deque


def newbie_cutter(people: list) -> int:
    document_rank = [0] * len(people)
    interview_rank = deque([0] * len(people))
    is_survived = [True] * len(people)
    for i, person in enumerate(people):
        document_rank[person[0] - 1] = i
        interview_rank[person[1] - 1] = i

    for person_num in document_rank:
        if not is_survived[person_num]:
            continue
        while interview_rank and person_num != interview_rank[-1]:
            is_survived[interview_rank[-1]] = False
            interview_rank.pop()
        if interview_rank:
            interview_rank.pop()

    count = 0
    for b in is_survived:
        if b:
            count += 1
    return count


t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    people = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]
    print(newbie_cutter(people))

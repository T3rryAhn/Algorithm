import sys
import heapq

n = int(sys.stdin.readline())
card = []

for _ in range(n):
    heapq.heappush(card, int(sys.stdin.readline()))

result = 0

while len(card) > 1:
    min1 = heapq.heappop(card)  # 가장 작은 카드 묶음
    min2 = heapq.heappop(card)  # 두 번째로 작은 카드 묶음

    sum_cards = min1 + min2  # 두 카드 묶음을 합친 크기
    result += sum_cards  # 합친 크기를 결과에 더함

    heapq.heappush(card, sum_cards)  # 합친 카드 묶음을 다시 최소 힙에 삽입

print(result)

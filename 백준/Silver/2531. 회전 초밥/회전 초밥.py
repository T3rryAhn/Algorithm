from sys import stdin
N, d, k, c = map(int, stdin.readline().split())
sushiBelt = [int(stdin.readline().strip()) for _ in range(N)]

sushi_dict = {}
max_types = 0

# 초기 구간 설정
for i in range(k):
    sushi_dict[sushiBelt[i % N]] = sushi_dict.get(sushiBelt[i % N], 0) + 1

# 쿠폰 초밥 추가
sushi_dict[c] = sushi_dict.get(c, 0) + 1

max_types = len(sushi_dict)

# 슬라이딩 윈도우
for start in range(1, N):
    end = (start + k - 1) % N
    start_sushi = sushiBelt[start - 1]
    end_sushi = sushiBelt[end]

    # 시작 초밥 제거
    if sushi_dict[start_sushi] == 1:
        del sushi_dict[start_sushi]
    else:
        sushi_dict[start_sushi] -= 1

    # 끝 초밥 추가
    sushi_dict[end_sushi] = sushi_dict.get(end_sushi, 0) + 1

    # 최대 종류 갱신
    if len(sushi_dict) > max_types:
        max_types = len(sushi_dict)

print(max_types)

def cal_over_averaged_percent(size: int, items: list) -> float:
    total_score = 0
    count_over_average = 0

    for item in items:
        total_score += item

    average = total_score / size

    for item in items:
        if item > average:
            count_over_average += 1
    return (count_over_average / size) * 100


c = int(input())

for _ in range(c):
    temp_input = input().split()
    num_people = int(temp_input[0])
    scores = list(map(int, temp_input[1:]))

    print(f'{cal_over_averaged_percent(num_people, scores):.3f}%')


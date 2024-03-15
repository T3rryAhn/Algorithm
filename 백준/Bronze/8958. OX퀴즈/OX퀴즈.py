t = int(input())

for _ in range(t):
    point = 1
    score = 0
    quiz_result = input()

    for i in range(len(quiz_result)):
        if quiz_result[i] == 'X':
            point = 1
            continue

        score += point
        point += 1

    print(score)
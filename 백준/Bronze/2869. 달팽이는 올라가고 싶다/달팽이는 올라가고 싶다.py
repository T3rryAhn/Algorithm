a, b, v = map(int, input().split())

last_distance = v % (a - b)
day_before_goal = (v - a) // (a - b)
day_before_goal_remainder = (v - a) % (a - b)
if day_before_goal_remainder:
    day_before_goal += 1  # 전날이 정수가 아닐 시 올림 처리

if last_distance <= a:
    day_before_goal += 1
else:
    day_before_goal += 2

print(day_before_goal)

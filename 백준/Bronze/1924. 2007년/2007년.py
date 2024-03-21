x, y = map(int, input().split())


def month(month: int):
    if month == 2:
        return 28
    if month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12:
        return 31
    else:
        return 30


def cal_day(x, y):
    day = 0
    for i in range(1, x):
        day += month(i)
    day += y

    return day


def show_day(day):
    str_day = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
    a = day % 7
    return str_day[a]


print(show_day(cal_day(x, y)))

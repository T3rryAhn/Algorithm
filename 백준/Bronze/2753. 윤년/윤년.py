year = int(input())
leap_year_flag = 0

if year % 400 == 0:
    leap_year_flag = 1
elif year % 4 == 0 and year % 100 != 0:
    leap_year_flag = 1

print(leap_year_flag)
